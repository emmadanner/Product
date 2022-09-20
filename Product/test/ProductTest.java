import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest
{

    ProductGenerator p1, p2, p3, p4, p5;

    @BeforeEach
    void setUp() {
        p1 = new ProductGenerator("000001", "Pipeweed", "Long Botton Leaf", 600.0);
        p2 = new ProductGenerator("000002", "Lembas", "Elven Wayfare Bread", 200.0);
        p3 = new ProductGenerator("000003", "Wine", "Woodland Elf Wine", 400.0);
        p4 = new ProductGenerator("000004", "Mushrooms", "Farmer Took's Finest", 125.0);
        p5 = new ProductGenerator("000005", "Mithril", "Enchanted Dwarven Armor", 3000.0);
    }

    @Test
    void setIDNum() {
        p1.setIDNum("00000A");
        assertEquals("00000A", p1.getIDNum());
    }

    @Test
    void setName() {
        p1.setName("Pipe Weed");
        assertEquals("Pipe Weed", p1.getName());
    }

    @Test
    void setDescription() {
        p1.setDescription("Elven Top Leaf");
        assertEquals("Elven Top Leaf", p1.getDescription());
    }

    @Test
    void setCost() {
        p1.setCost(500.0);
        assertEquals(500.0, p1.getCost());
    }
}