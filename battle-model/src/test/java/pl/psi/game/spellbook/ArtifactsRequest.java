//package pl.psi.game.spellbook;
//
//import org.junit.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class ArtifactsRequest {
//
//    @Test
//    void shouldReturnSpellDuration(){
//
//        // mam artefakt, który wydłuża czas trwania spella o jedną turę
//        // wiem, że muszę tego spella udekorować, czyli musze wymagac od grupy od czarow zeby
//        // mieli metodę "dealBuffDuration" i potem w dekoratorze zwiększyć ją o jeden?
//        // czy udekorować obiekt Spell i mu zwiekszyć długosc dzialania analogicznie do przykładu z zajęć dotyczącego
//        // kupowania kawy i zwiększania jej ceny poprzez mleko itp
//
//        SpellInfo spell = SpellBookInfoFactory.getSpell(SpellBookInfoFactory.AIR_SHIELD);
//        assertEquals("Air shield", spell.getName());
//        assertEquals(1, spell.getDuration());
//    }
//
//}
