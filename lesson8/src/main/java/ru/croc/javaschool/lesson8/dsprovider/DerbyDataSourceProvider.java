package ru.croc.javaschool.lesson8.dsprovider;

import org.apache.derby.jdbc.EmbeddedDataSource;
import ru.croc.javaschool.lesson8.property.PropertyContainer;

import javax.sql.DataSource;
import java.util.Objects;

/**
 * Провайдер источника данных для работы с Derby (JavaDB).
 */
public class DerbyDataSourceProvider implements DataSourceProvider {

    private EmbeddedDataSource dataSource;

    @Override
    public DataSource getDataSource() {
        if (Objects.isNull(dataSource)) {
            dataSource = new EmbeddedDataSource();
            dataSource.setDatabaseName(PropertyContainer.getProperty("database.name"));
            // задаем пользователя для всех будущих соединений с БД
            var username = PropertyContainer.getProperty("database.username");
            var password = PropertyContainer.getProperty("database.password");
            if (!username.isEmpty() && !password.isEmpty()) {
                dataSource.setUser(username);
                dataSource.setPassword(password);
            }
            dataSource.setCreateDatabase("create");
        }
        return dataSource;
    }
}