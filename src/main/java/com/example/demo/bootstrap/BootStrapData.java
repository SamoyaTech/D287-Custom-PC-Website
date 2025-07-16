package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final InhousePartRepository inhousePartRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (outsourcedPartRepository.count() == 0) {
            //creating an object from the OutsourcedPart class
            OutsourcedPart o1 = new OutsourcedPart();
            //setting values
            o1.setCompanyName("Western Governors University");
            o1.setName("CPU");
            o1.setInv(20);
            o1.setMinInv(1);
            o1.setMaxInv(100);
            o1.setPrice(1500.0);
            o1.setId(100L);
            outsourcedPartRepository.save(o1);

            OutsourcedPart thePart = null;
            List <OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts){
                if(part.getName().equals("CPU"))thePart=part;
            }

            System.out.println(thePart.getCompanyName());

            OutsourcedPart o2 = new OutsourcedPart();
            o2.setCompanyName("Western Governors University");
            o2.setName("Motherboard");
            o2.setInv(50);
            o2.setMinInv(1);
            o2.setMaxInv(100);
            o2.setPrice(200.0);
            o2.setId(101L);
            outsourcedPartRepository.save(o2);

            thePart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts){
                if(part.getName().equals("Motherboard"))thePart=part;
            }

            System.out.println(thePart.getCompanyName());

            //Show all outsourced parts
            outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts){
                System.out.println(part.getName()+" "+part.getCompanyName());
            }
        }

        if (inhousePartRepository.count() == 0) {

           //creating an object from the InHousePart class
            InhousePart i1 = new InhousePart();
            //setting values
            i1.setName("RAM");
            i1.setInv(80);
            i1.setMinInv(1);
            i1.setMaxInv(100);
            i1.setPrice(100.0);
            i1.setId(200L);
            inhousePartRepository.save(i1);

            InhousePart theInhousePart=null;
            List<InhousePart> inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for(InhousePart part:inhouseParts){
                if(part.getName().equals("RAM"))theInhousePart=part;
            }

            InhousePart i2 = new InhousePart();
            i2.setName("GPU");
            i2.setInv(50);
            i2.setMinInv(1);
            i2.setMaxInv(100);
            i2.setPrice(500.0);
            i2.setId(201L);
            inhousePartRepository.save(i2);

            theInhousePart = null;
            inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
            for(InhousePart part:inhouseParts){
                if(part.getName().equals("GPU"))theInhousePart=part;
            }

            InhousePart i3 = new InhousePart();
            i3.setName("SSD");
            i3.setInv(75);
            i3.setMinInv(1);
            i3.setMaxInv(100);
            i3.setPrice(70.0);
            i3.setId(202L);
            inhousePartRepository.save(i3);

            theInhousePart = null;
            inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
            for(InhousePart part:inhouseParts){
                if(part.getName().equals("SSD"))theInhousePart=part;
            }

            // Show all inhouse parts
            inhouseParts=(List<InhousePart>) inhousePartRepository.findAll();
            for(InhousePart part:inhouseParts){
                System.out.println(part.getName()+" "+part.getId());
            }
    }

        if (productRepository.count() == 0) {
            Product gamerXtreme = new Product("GamerXtreme", 3000, 80);
            Product eliteDesk = new Product("EliteDesk", 2600, 50);
            Product tridentUltra = new Product("Trident Ultra", 2900, 15);
            Product quantumForge = new Product("Quantum Forge", 3000, 20);
            Product pixelPhantom = new Product("Pixel Phantom", 3100, 65);
            productRepository.save(gamerXtreme);
            productRepository.save(eliteDesk);
            productRepository.save(tridentUltra);
            productRepository.save(quantumForge);
            productRepository.save(pixelPhantom);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
