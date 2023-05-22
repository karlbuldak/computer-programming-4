package pl.kbuldak;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.kbuldak.productcatalog.Product;

import java.util.UUID;

@SpringBootTest
public class JdbcPlaygroundTest {

    @Autowired
    JdbcTemplate db;

    @BeforeEach
    void setup(){
        db.execute("DROP TABLE `products` IF EXISTS");
        db.execute("CREATE TABLE `products` (" +
                "`id` VARCHAR(100)," +
                "`name` VARCHAR(100)," +
                "`desc` VARCHAR(300)," +
                "PRIMARY KEY(id)" +
                ")");
    }

    @Test
    void testIt(){
        String result = db.queryForObject(
                "select 'Hello world' ",
                String.class);

        assert result.equals("Hello world");
    }

    @Test
    void insert(){
        Product product = new Product(UUID.randomUUID(), "Lego", "Nice one");
        db.update("INSERT INTO `products` (`id`, `name`, `desc`) values (?, ?, ?)", product.getId(), product.getName(), product.getDesc());

        int productCount = db.queryForObject("SELECT count(*) from products", Integer.class);
        assert productCount == 1;
    }

    @Test
    void select(){
        Product product = new Product(UUID.randomUUID(), "Lego", "Nice one");
        db.update("INSERT INTO `products` (`id`, `name`, `desc`) values (?, ?, ?)", product.getId(), product.getName(), product.getDesc());

        int productCount = db.queryForObject("SELECT count(*) from products", Integer.class);
        assert productCount == 1;

        String sql = "select * from products where id = ?";

        db.queryForObject(sql, new Object[]{product.getId()}, (rs, i) -> {
            return new Product(
                    UUID.fromString(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("desc"));
        });
    }
}
