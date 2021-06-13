package by.training.service;

public class Task35 {

    /**
     * Calculate day and month
     * @param day
     * @return date
     * @return null, if day does not exist
     */

    public int[] findDate(int day) {

        //January
        if (day>0 && day < 32) {
            return (new int[]{day, 1});
        }

        //February
        if (day>31 && day<60 )
        {
            return (new int[]{day-31, 2});
        }

        //March

        if (day>59 && day<91 )
        {
            return (new int[]{day-59, 3});
        }

        // April

        if (day>90 && day<121 )
        {
            return (new int[]{day-90, 4});
        }

        //May

        if (day>120 && day<152 )
        {
            return (new int[]{day-120, 5});
        }

        //June

        if (day>151 && day<182 )
        {
            return (new int[]{day-151, 6});
        }

        //July

        if (day>181 && day<213 )
        {
            return (new int[]{day-181, 7});
        }

        //August

        if (day>212 && day<244 )
        {
            return (new int[]{day-212, 8});
        }

        //September

        if (day>243 && day<274 )
        {
            return (new int[]{day-243, 9});
        }

        //October

        if (day>273 && day<305 )
        {
            return (new int[]{day-273, 10});
        }

        //November

        if (day>304 && day<335 )
        {
            return (new int[]{day-304, 11});
        }

        //December

        if (day>334 && day<366 )
        {
            return (new int[]{day-334, 12});
        }

        // If day not [1,365], program enter null

        return null;
    }
}
