package com.aniruddha.researchproject

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val layoutManager = GridLayoutManager(this, 18)
        recyclerView.layoutManager = layoutManager

        val emptyElement = Element(-1, "", "", Color.WHITE)

        val elements = createSampleElements()

        val adapter = AdapterClass(elements) { selectedElement ->
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            intent.putExtra(
                "selectedLayoutId",
                R.layout.hydrogen
            ) // Replace with the desired layout resource ID
            intent.putExtra("selectedElement", selectedElement) // Pass the selected element
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }


    private fun createSampleElements(): List<Element> {
        return listOf(
            //1st Row
            Element(1, "H", "Hydrogen", Color.GREEN),//1
            Element(-1, "", "", Color.WHITE),//2
            Element(-1, "", "", Color.WHITE),//3
            Element(-1, "", "", Color.WHITE),//4
            Element(-1, "", "", Color.WHITE),//5
            Element(-1, "", "", Color.WHITE),//6
            Element(-1, "", "", Color.WHITE),//7
            Element(-1, "", "", Color.WHITE),//8
            Element(-1, "", "", Color.WHITE),//9
            Element(-1, "", "", Color.WHITE),//10
            Element(-1, "", "", Color.WHITE),//11
            Element(-1, "", "", Color.WHITE),//12
            Element(-1, "", "", Color.WHITE),//13
            Element(-1, "", "", Color.WHITE),//14
            Element(-1, "", "", Color.WHITE),//15
            Element(-1, "", "", Color.WHITE),//16
            Element(-1, "", "", Color.WHITE),//17
            Element(2, "He", "Helium",
                Color.parseColor("#27736C")),//18

            //2nd Row
            Element(3, "Li", "Lithium", Color.RED),//1
            Element(4, "Be", "Beryllium", Color.GREEN),//2
            Element(-1, "", "", Color.WHITE), //3
            Element(-1, "", "", Color.WHITE), //4
            Element(-1, "", "", Color.WHITE), //5
            Element(-1, "", "", Color.WHITE), //6
            Element(-1, "", "", Color.WHITE), //7
            Element(-1, "", "", Color.WHITE), //8
            Element(-1, "", "", Color.WHITE), //9
            Element(-1, "", "", Color.WHITE), //10
            Element(-1, "", "", Color.WHITE), //11
            Element(-1, "", "", Color.WHITE), //12
            Element(5, "B", "Boron",
                Color.parseColor("#B57414")),//13
            Element(6, "C", "Carbon", Color.GREEN),//14
            Element(7, "N", "Nitrogen", Color.GREEN),//15
            Element(8, "O", "Oxygen", Color.GREEN),//16
            Element(9, "F", "Fluorine", Color.MAGENTA),//17
            Element(10, "Ne", "Neon",
                Color.parseColor("#27736C")),//18

            //3rd Row
            Element(11, "Na", "Sodium", Color.RED),   // 1
            Element(12, "Mg", "Magnesium", Color.GREEN),   // 2
            Element(-1, "", "", Color.WHITE),   // 3
            Element(-1, "", "", Color.WHITE),   // 4
            Element(-1, "", "", Color.WHITE),   // 5
            Element(-1, "", "", Color.WHITE),   // 6
            Element(-1, "", "", Color.WHITE),   // 7
            Element(-1, "", "", Color.WHITE),   // 8
            Element(-1, "", "", Color.WHITE),   // 9
            Element(-1, "", "", Color.WHITE),   // 10
            Element(-1, "", "", Color.WHITE),   // 11
            Element(-1, "", "", Color.WHITE),   // 12
            Element(13, "Al", "Aluminum", Color.CYAN),   // 13
            Element(14, "Si", "Silicon",
                Color.parseColor("#B57414")),   // 14
            Element(15, "P", "Phosphorus", Color.GREEN),   // 15
            Element(16, "S", "Sulfur", Color.GREEN),   // 16
            Element(17, "Cl", "Chlorine", Color.MAGENTA),   // 17
            Element(18, "Ar", "Argon",
                Color.parseColor("#27736C")),  // 18

            //4th Row
            Element(19, "K", "Potassium", Color.RED),     // 1
            Element(20, "Ca", "Calcium", Color.GREEN),    // 2
            Element(21, "Sc", "Scandium",
                Color.parseColor("#673AB7")),    // 3
            Element(22, "Ti", "Titanium",
                Color.parseColor("#673AB7")),  // 4
            Element(23, "V", "Vanadium",
                Color.parseColor("#673AB7")),  // 5
            Element(24, "Cr", "Chromium",
                Color.parseColor("#673AB7")),    // 6
            Element(25, "Mn", "Manganese",
                Color.parseColor("#673AB7")),    // 7
            Element(26, "Fe", "Iron",
                Color.parseColor("#673AB7")),       // 8
            Element(27, "Co", "Cobalt",
                Color.parseColor("#673AB7")),      // 9
            Element(28, "Ni", "Nickel",
                Color.parseColor("#673AB7")),    // 10
            Element(29, "Cu", "Copper",
                Color.parseColor("#673AB7")),   // 11
            Element(30, "Zn", "Zinc",
                Color.parseColor("#673AB7")),        // 12
            Element(31, "Ga", "Gallium", Color.CYAN),      // 13
            Element(32, "Ge", "Germanium",
                Color.parseColor("#B57414")),  // 14
            Element(33, "As", "Arsenic",
                Color.parseColor("#B57414")),     // 15
            Element(34, "Se", "Selenium", Color.GREEN),  // 16
            Element(35, "Br", "Bromine", Color.MAGENTA),  // 17
            Element(36, "Kr", "Krypton",
                Color.parseColor("#27736C")) ,     // 18

            //5th Row
            Element(37, "Rb", "Rubidium", Color.RED),     // 1
            Element(38, "Sr", "Strontium", Color.GREEN),   // 2
            Element(39, "Y", "Yttrium",
                Color.parseColor("#673AB7")),        // 3
            Element(40, "Zr", "Zirconium",
                Color.parseColor("#673AB7")),   // 4
            Element(41, "Nb", "Niobium",
                Color.parseColor("#673AB7")),    // 5
            Element(42, "Mo", "Molybdenum",
                Color.parseColor("#673AB7")),    // 6
            Element(43, "Tc", "Technetium",
                Color.parseColor("#673AB7")),     // 7
            Element(44, "Ru", "Ruthenium",
                Color.parseColor("#673AB7")),    // 8
            Element(45, "Rh", "Rhodium",
                Color.parseColor("#673AB7")),       // 9
            Element(46, "Pd", "Palladium",
                Color.parseColor("#673AB7")),   // 10
            Element(47, "Ag", "Silver",
                Color.parseColor("#673AB7")),     // 11
            Element(48, "Cd", "Cadmium",
                Color.parseColor("#673AB7")),       // 12
            Element(49, "In", "Indium", Color.CYAN),         // 13
            Element(50, "Sn", "Tin", Color.CYAN),          // 14
            Element(51, "Sb", "Antimony",
                Color.parseColor("#B57414")),      // 15
            Element(52, "Te", "Tellurium",
                Color.parseColor("#B57414")),   // 16
            Element(53, "I", "Iodine", Color.MAGENTA),      // 17
            Element(54, "Xe", "Xenon",
                Color.parseColor("#27736C")) ,         // 18

            //6th Row
            Element(55, "Cs", "Cesium", Color.RED),      // 1
            Element(56, "Ba", "Barium", Color.GREEN),    // 2
            Element(57, "57-71", "La-Lu",
                Color.parseColor("#FF5733")),  // 3
            Element(72, "Hf", "Hafnium",
                Color.parseColor("#673AB7")),  // 4
            Element(73, "Ta", "Tantalum",
                Color.parseColor("#673AB7")),// 5
            Element(74, "W", "Tungsten",
                Color.parseColor("#673AB7")),    // 6
            Element(75, "Re", "Rhenium",
                Color.parseColor("#673AB7")),     // 7
            Element(76, "Os", "Osmium",
                Color.parseColor("#673AB7")),    // 8
            Element(77, "Ir", "Iridium",
                Color.parseColor("#673AB7")),    // 9
            Element(78, "Pt", "Platinum",
                Color.parseColor("#673AB7")), // 10
            Element(79, "Au", "Gold",
                Color.parseColor("#673AB7")),    // 11
            Element(80, "Hg", "Mercury",
                Color.parseColor("#673AB7")),    // 12
            Element(81, "Tl", "Thallium", Color.CYAN),    // 13
            Element(82, "Pb", "Lead", Color.CYAN),      // 14
            Element(83, "Bi", "Bismuth", Color.CYAN),    // 15
            Element(84, "Po", "Polonium",
                Color.parseColor("#B57414")), // 16
            Element(85, "At", "Astatine", Color.MAGENTA),// 17
            Element(86, "Rn", "Radon",
                Color.parseColor("#27736C")) ,      // 18

            //7th Row
            Element(87, "Fr", "Francium", Color.RED),    // 1
            Element(88, "Ra", "Radium", Color.GREEN),     // 2
            Element(89, "Ac-Lr", "89-103",
                Color.parseColor("#FF33A6")),    // 3
            Element(104, "Rf", "Rutherfordium",
                Color.parseColor("#673AB7")),  // 4
            Element(105, "Db", "Dubnium",
                Color.parseColor("#673AB7")),       // 5
            Element(106, "Sg", "Seaborgium",
                Color.parseColor("#673AB7")),       // 6
            Element(107, "Bh", "Bohrium",
                Color.parseColor("#673AB7")),           // 7
            Element(108, "Hs", "Hassium",
                Color.parseColor("#673AB7")),         // 8
            Element(109, "Mt", "Meitnerium",
                Color.parseColor("#673AB7")),       // 9
            Element(110, "Ds", "Darmstadtium",
                Color.parseColor("#673AB7")),   // 10
            Element(111, "Rg", "Roentgenium",
                Color.parseColor("#673AB7")),   // 11
            Element(112, "Cn", "Copernicium",
                Color.parseColor("#673AB7")),   // 12
            Element(113, "Nh", "Nihonium", Color.CYAN),      // 13
            Element(114, "Fl", "Flerovium", Color.CYAN),    // 14
            Element(115, "Mc", "Moscovium", Color.CYAN),      // 15
            Element(116, "Lv", "Livermorium", Color.CYAN),  // 16
            Element(117, "Ts", "Tennessine", Color.MAGENTA),  // 17
            Element(118, "Og", "Oganesson",
                Color.parseColor("#27736C")),    // 18

            // 5th Row Transition Metals
            Element(-1, "", "", Color.WHITE),
            Element(-1, "", "", Color.WHITE),
            Element(57, "La", "Lanthanum", Color.parseColor("#FF5733")),
            Element(58, "Ce", "Cerium", Color.parseColor("#FF5733")),
            Element(59, "Pr", "Praseodymium", Color.parseColor("#FF5733")),
            Element(60, "Nd", "Neodymium", Color.parseColor("#FF5733")),
            Element(61, "Pm", "Promethium", Color.parseColor("#FF5733")),
            Element(62, "Sm", "Samarium", Color.parseColor("#FF5733")),
            Element(63, "Eu", "Europium", Color.parseColor("#FF5733")),
            Element(64, "Gd", "Gadolinium", Color.parseColor("#FF5733")),
            Element(65, "Tb", "Terbium", Color.parseColor("#FF5733")),
            Element(66, "Dy", "Dysprosium", Color.parseColor("#FF5733")),
            Element(67, "Ho", "Holmium", Color.parseColor("#FF5733")),
            Element(68, "Er", "Erbium", Color.parseColor("#FF5733")),
            Element(69, "Tm", "Thulium", Color.parseColor("#FF5733")),
            Element(70, "Yb", "Ytterbium", Color.parseColor("#FF5733")),
            Element(71, "Lu", "Lutetium", Color.parseColor("#FF5733")),
            Element(-1, "", "", Color.WHITE),

            //6th Row Transition Metals
            Element(-1, "", "", Color.WHITE),
            Element(-1, "", "", Color.WHITE),
            Element(89, "Ac", "Actinium", Color.parseColor("#FF33A6")),
            Element(90, "Th", "Thorium", Color.parseColor("#FF33A6")),
            Element(91, "Pa", "Protactinium", Color.parseColor("#FF33A6")),
            Element(92, "U", "Uranium", Color.parseColor("#FF33A6")),
            Element(93, "Np", "Neptunium", Color.parseColor("#FF33A6")),
            Element(94, "Pu", "Plutonium", Color.parseColor("#FF33A6")),
            Element(95, "Am", "Americium", Color.parseColor("#FF33A6")),
            Element(96, "Cm", "Curium", Color.parseColor("#FF33A6")),
            Element(97, "Bk", "Berkelium", Color.parseColor("#FF33A6")),
            Element(98, "Cf", "Californium", Color.parseColor("#FF33A6")),
            Element(99, "Es", "Einsteinium", Color.parseColor("#FF33A6")),
            Element(100, "Fm", "Fermium", Color.parseColor("#FF33A6")),
            Element(101, "Md", "Mendelevium", Color.parseColor("#FF33A6")),
            Element(102, "No", "Nobelium", Color.parseColor("#FF33A6")),
            Element(103, "Lr", "Lawrencium", Color.parseColor("#FF33A6")),
            Element(-1, "", "", Color.WHITE)
            )

    }

}
