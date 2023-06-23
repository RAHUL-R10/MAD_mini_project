package com.example.plant_diseasedetection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ResultInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_info)
        var results=intent.getStringExtra("info")
        val mResultInfo = findViewById<TextView>(R.id.result_info)
        val mTitle = findViewById<TextView>(R.id.disease_result_text)
        val mImage = findViewById<ImageView>(R.id.disease_imageView_result)

        if (results != null) {
            if(results.contains("apple scab")){
                mTitle.text="Apple Scab"
                mImage.setImageResource(R.drawable.applescab)
                mResultInfo.text = "1.\tFor best control, spray liquid copper soap early, two weeks before symptoms normally appear. Alternatively, " +
                        "begin applications when disease first appears, and repeat at 7 to 10 day intervals up to blossom drop.\n" +
                        "2.\tOrganocide® Plant Doctor is an earth-friendly systemic fungicide that works its way through the entire plant to combat a " +
                        "large number of diseases on ornamentals, turf, fruit and more. Apply as a soil drench or foliar spray (3-4 tsp/ gallon of water) " +
                        "to prevent and attack fungal problems.\n"
            }
            else if(results.contains("apple black rot")){
                mTitle.text="Apple Black Rot"
                mImage.setImageResource(R.drawable.applerot)
                mResultInfo.text =  " black rot on apple trees starts with sanitation. Because fungal spores overwinter on fallen leaves, " +
                        "mummified fruits, dead bark and cankers, it’s important to keep all the fallen debris and dead fruit cleaned up and away from the tree."
            }
            else if(results.contains("apple cedar apple rust")){
                mTitle.text="Apple Cedar/Apple rust"
                mImage.setImageResource(R.drawable.applerust)
                mResultInfo.text = "Apply preventative, disease-fighting fungicides labeled for use on apples weekly, starting with bud break, " +
                        "to protect trees from spores being released by the juniper host. This occurs only once per year, so additional applications " +
                        "after this springtime spread are not necessary."
            }
            else if(results.contains("blueberry healthy")){
                mTitle.text="Blueberry Healthy"
                mImage.setImageResource(R.drawable.blueberryhealthy)
                mResultInfo.text = "Congratulations! Your plant is healthy"
            }
            else if(results.contains("cherry including sour powdery mildew")){
                mTitle.text="Cherry including sour powdery mildew"
                mImage.setImageResource(R.drawable.cherryincludingsourpowderymildew)
                mResultInfo.text = "The best fungicides currently available for powdery mildew control are the new SDHI " +
                        "premixes Luna Sensation and Merivon and the stobilurin fungicide Gem. Other fungicides including sterol-inhibitors " +
                        "and sulfur provide some powdery mildew control, but are not nearly as effective as Luna Sensation, Merivon or Gem."
            }
            else if(results.contains("cherry including sour healthy")){
                mTitle.text="Cherry including sour healthy"
                mImage.setImageResource(R.drawable.cherryincludingsourhealthy)
                mResultInfo.text = "Congratulations! Your plant is healthy"
            }
            else if(results.contains("corn maize cercospora leaf spot gray leaf spot")){
                mTitle.text="corn maize cercospora leaf spot gray leaf spot"
                mImage.setImageResource(R.drawable.cornmaizecercospora)
                mResultInfo.text = "Crop rotation and clean plowing are effective at reducing in-field inoculum buildup. A two-year crop rotation " +
                        "away from corn is effective if reduced tillage must be maintained for conservation purposes or a one-year rotation with clean " +
                        "plowing is recommended in fields that have had a problem with the disease\n Hybrids with partial resistance to GLS are available. \n"
            }
            else if(results.contains("corn maize common rust")){
                mTitle.text="Corn maize common rust"
                mImage.setImageResource(R.drawable.cornmaizecommonrust)
                mResultInfo.text = "Fungicides have been used against both common and southern rust, but they " +
                        "are usually not needed in maize because of the resistance bred into commercialvarieties. However," +
                        " foliar fungicides may have a use on sweet corn. A number of protectant fungicide have been recommended: e.g., " +
                        "chlorothalonil or mancozeb. Plants are monitored and sprays commence when there are on average six pustules per leaf."
            }
            else if(results.contains("corn maize northern leaf blight")){
                mTitle.text="Corn maize northern leaf blight"
                mImage.setImageResource(R.drawable.cornmaizenorthernleafblight)
                mResultInfo.text = "•\tCrop rotation to reduce previous corn residues and disease inoculum\n" +
                        "•\tTillage to help break down crop debris and reduce inoculum load\n" +
                        "•\tFungicide application to reduce yield loss and improve harvestability\n" +
                        "•\tConsider hybrid susceptibility, previous crop, tillage, field history, application cost, corn price\n"
            }
            else if(results.contains("corn maize healthy")){
                mTitle.text="Corn maize healthy"
                mImage.setImageResource(R.drawable.cornmaizehealthy)
                mResultInfo.text = "Congratulations! Your plant is healthy"
            }
            else if(results.contains("grape black rot")){
                mTitle.text="Grape black rot"
                mImage.setImageResource(R.drawable.grapeblackrot)
                mResultInfo.text = "Cut off the obviously affected parts of the grape vine with a sterile knife. " +
                        "Remove all spotted leaves and the black, mummified grapes. Be extremely thorough and make sure you remove" +
                        " all parts of the plant that are affected by the black rot."
            }
            else if(results.contains("grape esca black measles")){
                mTitle.text="grape esca black measles "
                mImage.setImageResource(R.drawable.grapeescablackmeasles)
                mResultInfo.text = "Presently, there are no effective management strategies for measles. Wine grape " +
                        "growers with small vineyards will often have field crews remove infected fruit prior to harvest. Raisins " +
                        "affected by measles will be discarded during harvest or at the packing house, while table grape growers will " +
                        "leave affected fruit on the vine. Current research is focused on protecting pruning wounds from fungal infections " +
                        "to minimize suspect fungi from colonizing fresh wounds."
            }
            else if(results.contains("grape leaf blight isariopsis leaf spot")){
                mTitle.text="Grape leaf blight isariopsis leaf spot"
                mImage.setImageResource(R.drawable.grapeleafblightisariopsisleafspot)
                mResultInfo.text ="Plant less susceptible varieties; reduce amount of vegetative growth on vines; do not " +
                        "over fertilize; use suitable trellises to increase air circulation in canopy and expose grape clusters " +
                        "to sun; disease usually merits chemical control"
            }
            else if(results.contains("grape healthy")){
                mTitle.text="Grape healthy"
                mImage.setImageResource(R.drawable.grapehealthy)
                mResultInfo.text ="Congratulations! Your plant is healthy"
            }
            else if(results.contains("orange haunglongbing citrus greening")){
                mTitle.text="Orange haunglongbing citrus greening"
                mImage.setImageResource(R.drawable.orangecitrus)
                mResultInfo.text = "Heating HLB-infected trees in the sun by encasing them in plastic “tents” slows or" +
                        " diminishes the psyllid count, which may potentially prolong the productivity of " +
                        "trees. Steam treatment also shows promise for extending the tree’s lifespan and ability " +
                        "to produce fruit. With thousands of acres of citrus groves infected with greening, this method" +
                        " poses implementation challenges. Researchers are currently looking at ways in which this can be done on a larger scale."
            }
            else if(results.contains("peach bacterial spot")){
                mTitle.text="Peach bacterial spot"
                mImage.setImageResource(R.drawable.peachbacterialspot)
                mResultInfo.text = "Oxytetracycline is generally considered the most effective compound and the least prone to " +
                        "phytotoxicity problems (damage to plant tissue), but also perhaps most likely to lose" +
                        " effectiveness with the appearance of bacterial strains with resistance. There is some " +
                        "evidence that the hydrochloride form of oxytetracycline (Fireline) is more effective than " +
                        "the calcium form Mycoshield."
            }
            else if(results.contains("peach healthy")){
                mTitle.text="Peach healthy"
                mImage.setImageResource(R.drawable.peachhealthy)
                mResultInfo.text = "Congratulations! Your plant is healthy"
            }
            else if(results.contains("pepper bell bacterial spot")){
                mTitle.text="Pepper bell bacterial spot"
                mImage.setImageResource(R.drawable.pepperbellbacterialspot)
                mResultInfo.text = "1.\tPurchase disease-free seed and transplants.\n" +
                        "\n2.\tTreat seeds by soaking them for 2 minutes in a 10% chlorine bleach solution (1 part bleach; 9 parts water). " +
                        "Thoroughly rinse seeds and dry them before planting.\n"
            }
            else if(results.contains("pepper bell healthy")){
                mTitle.text="Pepper bell healthy"
                mImage.setImageResource(R.drawable.pepperbellhealthy)
                mResultInfo.text = "Congratulations! Your plant is healthy"
            }
            else if(results.contains("potato early blight")){
                mTitle.text="Potato early blight"
                mImage.setImageResource(R.drawable.potatoearlyblight)
                mResultInfo.text ="Containing copper and pyrethrins, Bonide® Garden Dust is a safe, one-step control for many insect attacks " +
                        "and fungal problems." +
                        " For best results, cover both the tops and undersides of leaves with a thin uniform film or dust. Depending on foliage " +
                        "density, 10 oz will cover 625 sq ft. Repeat applications every 7-10 days, as needed.\n"
            }
            else if(results.contains("potato late blight")){
                mTitle.text="Potato late blight"
                mImage.setImageResource(R.drawable.potatolateblight)
                mResultInfo.text = "Chemical management is very popular strategy for the management of late blight. Since the discovery of " +
                        "Bordeaux mixture in 1885 and it was first important landmark in the history of chemical disease control." +
                        " Bordeaux mixture belongs to first generation of fungicides along with other inorganic chemicals. "
            }
            else if(results.contains("potato healthy")){
                mTitle.text="potato healthy"
                mImage.setImageResource(R.drawable.potatohealthy)
                mResultInfo.text = "Congratulations! Your plant is healthy"
            }
            else if(results.contains("raspberry healthy")){
                mTitle.text="Raspberry healthy"
                mImage.setImageResource(R.drawable.raspberryhealthy)
                mResultInfo.text = "1.\tPurchase disease-free seed and transplants.\n" +
                        "\n2.\tTreat seeds by soaking them for 2 minutes in a 10% chlorine bleach solution (1 part bleach; 9 parts water). " +
                        "Thoroughly rinse seeds and dry them before planting.\n"
            }
            else if(results.contains("pepper bell bacterial spot")){
                mTitle.text="Pepper bell bacterial spot"
                mImage.setImageResource(R.drawable.pepperbellbacterialspot)
                mResultInfo.text = "Congratulations! Your plant is healthy"
            }
            else if(results.contains("soybean healthy")){
                mTitle.text="Soybean healthy"
                mImage.setImageResource(R.drawable.soybeanhealthy)
                mResultInfo.text = "Congratulations! Your plant is healthy"
            }
            else if(results.contains("squash powdery mildew")){
                mTitle.text="Squash powdery mildew"
                mImage.setImageResource(R.drawable.squashpowderymildew)
                mResultInfo.text = "Baking Soda. Baking soda itself isn’t normally effective as a powdery mildew treatment, " +
                        "but when it’s combined with liquid soap and water, it can be a powerful weapon. It’s " +
                        "normally most beneficial if used as a preventative measure rather than a treatment. Combine " +
                        "one tablespoon baking soda and one-half teaspoon of liquid, non-detergent soap with one gallon of " +
                        "water, and spray the mixture liberally"
            }
            else if(results.contains("strawberry leaf scorch")){
                mTitle.text="Strawberry leaf scorch"
                mImage.setImageResource(R.drawable.strawberryleafscorch)
                mResultInfo.text =  "Although often easier said than done, it is important to purchase the highest quality " +
                        "seed possible. The seed extraction process will not reliably eliminate bacteria from " +
                        "the seed so treating the seed either with a chlorine bleach to disinfest the seed surface " +
                        "or a hot-water seed treatment to disinfest the seed surface as well as eliminate bacteria that " +
                        "may be under the seed coat may be necessary"
            }
            else if(results.contains("strawberry healthy")){
                mTitle.text="Strawberry healthy"
                mImage.setImageResource(R.drawable.strawberryhealthy)
                mResultInfo.text = "Congratulations! Your plant is healthy"
            }
            else if(results.contains("tomato bacterial spot")){
                mTitle.text="Tomato bacterial spot"
                mImage.setImageResource(R.drawable.tomatobacterialspot)
                mResultInfo.text ="Although often easier said than done, it is important to purchase the highest quality seed possible. " +
                        "The seed extraction process will not reliably eliminate bacteria from the seed so treating the seed " +
                        "either with a chlorine bleach to disinfest the seed surface or a hot-water seed treatment to disinfest " +
                        "the seed surface as well as eliminate bacteria that may be under the seed coat may be necessary"
            }
            else if(results.contains("tomato early blight")){
                mTitle.text="Tomato early blight"
                mImage.setImageResource(R.drawable.tomatoearlyblight)
                mResultInfo.text =  "1.\tPrune or stake plants to improve air circulation and reduce fungal problems.\n" +
                        "2.\tMake sure to disinfect your pruning shears (one part bleach to 4 parts water) after each cut.\n" +
                        "3.\tKeep the soil under plants clean and free of garden debris.\n" +
                        "\n"
            }
            else if(results.contains("tomato late blight")){
                mTitle.text="Tomato late blight"
                mImage.setImageResource(R.drawable.tomatolateblight)
                mResultInfo.text = "1.\tPlant resistant cultivars when available.\n" +
                        "2.\tRemove volunteers from the garden prior to planting and space plants far enough apart to allow for plenty of air circulation.\n" +
                        "3.\tWater in the early morning hours, or use soaker hoses, to give plants time to dry out during the day — avoid overhead irrigation.\n"
            }
            else if(results.contains("tomato leaf mold")){
                mTitle.text="Tomato leaf mold"
                mImage.setImageResource(R.drawable.tomatoleafmold)
                mResultInfo.text = "The pathogen P. fulfa can survive on infected plant debris or in the soil, although the initial" +
                        " source of the disease is often infected seed. The disease is spread by rain and wind, on tools, clothing" +
                        " and via insect activity. High relative humidity (greater that 85%) combined with high temperatures encourages" +
                        " the spread of the disease. With that in mind, if growing tomatoes in a greenhouse, maintain night temps higher " +
                        "than outside temperatures."
            }
            else if(results.contains("tomato septoria leaf spot")){
                mTitle.text="Tomato septoria leaf spot"
                mImage.setImageResource(R.drawable.tomatoseptorialeafspot)
                mResultInfo.text = "Treat organically with copper spray, which you can purchase online, at the hardware store, " +
                        "or home improvement center. Follow label directions. You can apply until the leaves are dripping, " +
                        "once a week and after each rain."
            }
            else if(results.contains("tomato spider mites two spotted spider mite")){
                mTitle.text="Tomato spider mites two spotted spider mite"
                mImage.setImageResource(R.drawable.tomatospidermitestwospottedspidermite)
                mResultInfo.text = "1.\tMix Pure Neem Oil with Coco-Wet and apply every 3-5 days to kill pest eggs indoors and interrupt the reproductive cycle. " +
                        "Make sure to spray all plant parts, including the undersides of leaves. Do NOT apply when temperatures exceed 90˚F and wait at last " +
                        "six hours before turning lights on.\n" +
                        "2.\tIf populations are high, use a least-toxic, short-lived pesticide (Take Down Spray, Doktor Doom Foggers) to " +
                        "reduce infestations, then release predatory mites to maintain control.\n"
            }
            else if(results.contains("tomato target spot")){
                mTitle.text="Tomato target spot"
                mImage.setImageResource(R.drawable.tomatotargetspot)
                mResultInfo.text = "Spray with protectant fungicides after first symptoms appear. Consult with your local extension " +
                        "agent for fungicides available in your region. Remove affected debris to prevent carryover into the next crop. " +
                        "Use an adequate period of crop rotation. Genetic resistance to this fungus has been documented in tomato and soybean but " +
                        "commercial varieties are not yet available."
            }
            else if(results.contains("tomato yellow leaf curl virus")){
                mTitle.text="Tomato yellow leaf curl virus"
                mImage.setImageResource(R.drawable.tomatoyellowleafcurlvirus)
                mResultInfo.text = "Inspect plants for whitefly infestations two times per week. If whiteflies are beginning to " +
                        "appear, spray with azadirachtin (Neem), pyrethrin or insecticidal soap. For more effective control, " +
                        "it is recommended that at least two of the above insecticides be rotated at each spraying. Follow label " +
                        "directions closely for dosage rates, spray intervals and precautions. Spray the undersides of the leaves thoroughly"
            }
            else if(results.contains("tomato mosaic virus")){
                mTitle.text="Tomato mosaic virus"
                mImage.setImageResource(R.drawable.tomatomosaicvirus)
                mResultInfo.text = "1.\the virus can be spread through human activity, tools and equipment. Frequently wash your hands and disinfect " +
                        "garden tools, stakes, ties, pots, greenhouse benches, etc. (one part bleach to 4 parts water) to reduce the risk of contamination.\n" +
                        "2.\tAvoid working in the garden during damp conditions (viruses are easily spread when plants are wet).\n" +
                        "3.\tAvoid using tobacco around susceptible plants. Cigarettes and other tobacco products may be infected and can spread the virus.\n"
            }
            else if(results.contains("tomato healthy")){
                mTitle.text="Tomato healthy"
                mImage.setImageResource(R.drawable.tomatohealthy)
                mResultInfo.text = "Congratulations! Your plant is healthy"
            }
            else if(results.contains("null")){
                mResultInfo.text = "Disease not found!!"
            }
        }
    }
}