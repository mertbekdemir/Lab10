/**
 * Class Canada contains the provinces and territories, and their population.
 *
 * @author  Joe Developer
 * @version 1.0
 */
import java.util.ArrayList;

public class Canada
{
    private ArrayList<ProvinceTerritory> provinces;

    public final static int NUM_OF_PROVINCES    = 13;
    public final static int NO_SUCH_PROVINCE    = -1;

    public static final int AB = 0;
    public static final int BC = 1;
    public static final int MB = 2;
    public static final int NB = 3;
    public static final int NL = 4;
    public static final int NT = 5;
    public static final int NS = 6;
    public static final int NU = 7;
    public static final int ON = 8;
    public static final int PE = 9;
    public static final int QC = 10;
    public static final int SK = 11;
    public static final int YT = 12;

    /** 
     *  Create provinces and territories in Canada
     */
    public Canada()
    {

        provinces = new ArrayList<ProvinceTerritory>();

        provinces.add(new ProvinceTerritory("Alberta" , 3645257));
        provinces.add(new ProvinceTerritory("British Columbia" , 4400057));
        provinces.add(new ProvinceTerritory("Manitoba" , 1208268));
        provinces.add(new ProvinceTerritory("New Brunswick" , 751171));
        provinces.add(new ProvinceTerritory("Newfoundland and Labrador" , 514536));
        provinces.add(new ProvinceTerritory("Northwest Territories" , 41462));
        provinces.add(new ProvinceTerritory("Nova Scotia" , 921727));
        provinces.add(new ProvinceTerritory("Nunavut" , 31906));
        provinces.add(new ProvinceTerritory("Ontario" , 12851821));
        provinces.add(new ProvinceTerritory("Prince Edward Island" , 140204));
        provinces.add(new ProvinceTerritory("Quebec" , 7903001));
        provinces.add(new ProvinceTerritory("Saskatchewan" , 1033381));
        provinces.add(new ProvinceTerritory("Yukon", 33897 ));
        provinces.add(null);

    }  

    /** 
     *  Gets the total population of Canada
     *  
     *  @return totalPopulation Total population of provinces and territories in Canada
     */
    public int getTotalPopulation()
    {
        int totalPopulation = 0;

        for (ProvinceTerritory eachProv : provinces)
        {
            if(eachProv != null) {
                totalPopulation +=  eachProv.getPopulation();
            }
        }
        return totalPopulation;
    }

    /**
     * Finds the province with the lowest population.
     * 
     * @return  Name of the province or territory with the lowest population
     */
    public String getLowestPopulation()
    {
        int     lowestPopulation = Integer.MAX_VALUE;
        String  smallestProvince = "";

        for (ProvinceTerritory eachProv : provinces)
        {
            if(eachProv != null) {
                if (eachProv.getPopulation() < lowestPopulation)
                {
                    lowestPopulation = eachProv.getPopulation();
                    smallestProvince = eachProv.getName();
                }

            }  
        }
        return smallestProvince;
    }

    /**
     * Finds the province with the highest population.
     * 
     * @return name of the province with the highest population
     */
    public ProvinceTerritory getHighestPopulation() 
    {
        int     highestPopulation = Integer.MIN_VALUE;
        ProvinceTerritory  biggestProvince = null;

        for (ProvinceTerritory eachProv : provinces)
        {
            if(eachProv != null && eachProv.getPopulation() > highestPopulation) {

                highestPopulation = eachProv.getPopulation();
                biggestProvince = eachProv;
            }

        }  

        return biggestProvince;

    }

    /**
     * Gets the population of a specific province.
     * 
     * @return  Population of the province or territory
     * @param   province    Name of the province or territory
     */
    public int getPopulation(String province)
    {

        if (province == null || province.equals(""))
            throw new IllegalArgumentException("Invalid Province");

        for (ProvinceTerritory eachProv : provinces)
        {
            if(eachProv != null){
                if (eachProv.getName().equalsIgnoreCase(province))
                {
                    return eachProv.getPopulation();
                }
            }

        }  

        return NO_SUCH_PROVINCE;
    }

    /** 
     * Determines if the province/territory is in Canada.
     * 
     * @return  Whether there is a province or territory with the given name
     * @name    Name of the province or territory
     */
    public boolean isProvinceInCanada(String name)
    {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Invalid name");
        }

        boolean isProvinceInCanada = false;

        for (ProvinceTerritory eachProv : provinces)
        {
            if (eachProv != null && eachProv.getName().equalsIgnoreCase(name))
            {
                isProvinceInCanada = true;
            }
        }

        return isProvinceInCanada;
    }

    /**
     * Gets all province names that contain the given substring.
     * 
     * @param   substring   Substring to search for in the name of province or territory
     * @return  Array of provinces or territories names with the substring in their names
     */
    public ProvinceTerritory[] getProvincesWhoseNameContains(String substring)
    {
        if (substring == null || substring.equals("")) {
            throw new IllegalArgumentException("Invalid string");
        }

        int i = 0;
        int j = 0;
        int numOfProvContainingString = 0;
        ProvinceTerritory[] containingString;

        for (ProvinceTerritory eachProv : provinces)
        {
            if (eachProv != null && eachProv.getName().toLowerCase().contains(substring.toLowerCase()))
            {
                numOfProvContainingString++;
            }
            i++;
        }

        if (numOfProvContainingString > 0)
        {
            containingString = new ProvinceTerritory[numOfProvContainingString];
        }
        else {
            return null;
        }

        i = 0;
        for (ProvinceTerritory eachProv : provinces)
        {
            if (eachProv != null && eachProv.getName().toLowerCase().contains(substring.toLowerCase()))
            {
                containingString[j] = eachProv;
                j++;
            }
            i++;
        }

        return containingString;
    }

    /**
     * Gets all provinces that contain the given substring.
     * 
     * @param   substring   Substring to search for in the name of province or territory
     * @return  Array of provinces or territories with the substring in their names
     */
    public ArrayList<ProvinceTerritory> getMoreProvincesWhoseNameContains(String substring)
    {
        if (substring == null || substring.equals("")) {
            throw new IllegalArgumentException("Invalid string");
        }

        int numOfProvContainString = 0;
        ArrayList<ProvinceTerritory> containString;

        for (ProvinceTerritory eachProv : provinces)
        {
            if ((eachProv != null && eachProv.getName().toLowerCase().contains(substring.toLowerCase())))
            {
                numOfProvContainString++;
            }
        }        

        if (numOfProvContainString > 0)
        {
            containString = new ArrayList<ProvinceTerritory>();
        }
        else {
            return null;
        }

        for (ProvinceTerritory eachProv : provinces)
        {
            if ((eachProv != null && eachProv.getName().toLowerCase().contains(substring.toLowerCase())))
            {
                containString.add(eachProv);

            }
        }            

        return  containString;
    }

    public ArrayList<String> getProvincesWhoseNameStartsWith(char letter)
    {
        if (letter == ' ' || letter == '\0') {
            throw new IllegalArgumentException("Invalid letter");
        }
           
        ArrayList<String> prov = new ArrayList<>();
        for(ProvinceTerritory province : provinces)
        {
            if ( province != null && province.getName().toLowerCase().charAt(0) == Character.toLowerCase(letter))
            {
                prov.add(province.getName());
            }
           
        }
        if (prov.size() > 0)
        {
            return prov;
        }
        else{
            return null;
        }
    }

    
}

