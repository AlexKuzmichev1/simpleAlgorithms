package Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GraphWeightsModel {

    private int youToAlice;
    private int youToBob;
    private int youToClaire;
    private int bobToAnuj;
    private int bobToPeggy;
    private int aliceToPeggy;
    private int claireToThom;
    private int claireToJonny;
}
