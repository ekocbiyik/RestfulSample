import com.ekocbiyik.model.Araba;
import com.ekocbiyik.model.Personel;
import com.ekocbiyik.service.IPersonelService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by enbiya on 02.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:hibernate-config.xml")
public class PersonelCrudTest {

    @Autowired
    private IPersonelService personelService;

    @Before
    public void testPersonelSave() {
        List<Araba> p1Cars = new ArrayList<>();
        p1Cars.add(new Araba("BMW", "SIYAH"));
        p1Cars.add(new Araba("MERCEDES", "SIYAH"));
        Personel p1 = new Personel("Enbiya", "Koçbıyık", p1Cars);
        personelService.savePersonel(p1);

//        List<Araba> p2Cars = new ArrayList<>();
//        p2Cars.add(new Araba("BMW", "BORDO"));
//        Personel p2 = new Personel("Ahmet", "Ahmetoğlu", p2Cars);
//        personelService.savePersonel(p2);
//
//        List<Araba> p3Cars = new ArrayList<>();
//        Personel p3 = new Personel("Mehmet", "Mehmetoğlu", p3Cars);
//        personelService.savePersonel(p3);
    }

    @Test
    public void testgetAllPersonels() {
        for (Personel p : personelService.getAllPersonels())
            System.out.println(p.getPersonelId() + " " + p.getAd() + " " + p.getSoyad() + " - " + p.getArabalar().toString());
    }
}
