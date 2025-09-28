/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructure.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

/**
 *
 * @author PABLO TREJO
 */
public class DatabaseConfig {
    private static final String PROPERTIES_FILE = "/application.properties";
    private static DataSource dataSource;
    private static Properties properties;
    
    static {
        loadProperties();
        initializeDataSource();
    }
    
    /**
     * Carga las propiedades desde el archivo de configuración
     */
    private static void loadProperties() {
        properties = new Properties();
        try (InputStream input = DatabaseConfig.class.getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                // Fallback a configuración por defecto si no existe el archivo
                loadDefaultProperties();
                return;
            }
            properties.load(input);
        } catch (IOException e) {
            loadDefaultProperties();
        }
    }
    
    /**
     * Configuración por defecto si no existe archivo de propiedades
     */
    private static void loadDefaultProperties() {
        properties.setProperty("db.driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.setProperty("db.url", "jdbc:sqlserver://localhost:1433;databaseName=LIBRERIA;encrypt=false;trustServerCertificate=true");
        properties.setProperty("db.username", "u_ventas");
        properties.setProperty("db.password", "u_ventas");
        properties.setProperty("db.pool.maximum-size", "20");
        properties.setProperty("db.pool.minimum-idle", "5");
        properties.setProperty("db.pool.connection-timeout", "30000");
        properties.setProperty("db.pool.idle-timeout", "600000");
        properties.setProperty("db.pool.max-lifetime", "1800000");
    }
    
    /**
     * Inicializa el pool de conexiones HikariCP
     */
    private static void initializeDataSource() {
        try {
            HikariConfig config = new HikariConfig();
            
            // Configuración básica
            config.setDriverClassName(properties.getProperty("db.driver"));
            config.setJdbcUrl(properties.getProperty("db.url"));
            config.setUsername(properties.getProperty("db.username"));
            config.setPassword(properties.getProperty("db.password"));
            
            // Configuración del pool
            config.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.pool.maximum-size", "20")));
            config.setMinimumIdle(Integer.parseInt(properties.getProperty("db.pool.minimum-idle", "5")));
            config.setConnectionTimeout(Long.parseLong(properties.getProperty("db.pool.connection-timeout", "30000")));
            config.setIdleTimeout(Long.parseLong(properties.getProperty("db.pool.idle-timeout", "600000")));
            config.setMaxLifetime(Long.parseLong(properties.getProperty("db.pool.max-lifetime", "1800000")));
            
            // Configuración adicional para optimización
            config.setLeakDetectionThreshold(60000); // Detectar leaks de conexión
            config.setPoolName("LibreriaPool");
            
            // Validación de conexiones
            config.setConnectionTestQuery("SELECT 1");
            config.setValidationTimeout(5000);
            
            dataSource = new HikariDataSource(config);
            
        } catch (Exception e) {
            throw new RuntimeException("Error al inicializar el pool de conexiones", e);
        }
    }
    
    /**
     * Obtiene la instancia del DataSource
     * @return DataSource configurado
     */
    public static DataSource getDataSource() {
        return dataSource;
    }
    
    /**
     * Cierra el pool de conexiones
     */
    public static void closeDataSource() {
        if (dataSource instanceof HikariDataSource) {
            ((HikariDataSource) dataSource).close();
        }
    }
    
    /**
     * Obtiene una propiedad de configuración
     * @param key Clave de la propiedad
     * @return Valor de la propiedad
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
    
    /**
     * Obtiene información del estado del pool de conexiones
     * @return String con información del pool
     */
    public static String getPoolInfo() {
        if (dataSource instanceof HikariDataSource) {
            HikariDataSource hds = (HikariDataSource) dataSource;
            return String.format("Pool: %s, Active: %d, Idle: %d, Waiting: %d, Total: %d",
                hds.getPoolName(),
                hds.getHikariPoolMXBean().getActiveConnections(),
                hds.getHikariPoolMXBean().getIdleConnections(),
                hds.getHikariPoolMXBean().getThreadsAwaitingConnection(),
                hds.getHikariPoolMXBean().getTotalConnections()
            );
        }
        return "Pool information not available";
    }
}
