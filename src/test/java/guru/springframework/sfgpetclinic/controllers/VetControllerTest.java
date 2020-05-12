package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@Tag("controllers")
class VetControllerTest {

    @Test
    void viewName() {
        VetService vetService = mock(VetService.class);
        VetController vetController = new VetController(vetService);
        Model model = mock(Model.class);

        assertThat(vetController.listVets(model)).isEqualTo("vets/index");
    }

    @Test
    void addToList() {
        SpecialtyService specialityService = new SpecialityMapService();
        VetService vetService = new VetMapService(specialityService);
        Vet vet1 = new Vet(1L, "joe", "buck", null);
        Vet vet2 = new Vet(2L, "jane", "smith", null);

        vetService.save(vet1);
        vetService.save(vet2);

        VetController vetController = new VetController(vetService);
        ModelMapImpl model = new ModelMapImpl();
        vetController.listVets(model);

        Set<Vet> modelAttribute = (Set<Vet>) model.getMap().get("vets");
        assertThat(modelAttribute.size()).isEqualTo(2);
    }
}