package by.training.service.task11;

public class CompareTriangle {

    /**
     * Function compare triangle
     * @param first
     * @param second
     * @return 1 if First triangle larger second
     *         0 equal
     *         -1 if Second triangle larger first
     */

    public int compareSquare(Triangle first,Triangle second)
    {
        if (first.calculateSquare()>second.calculateSquare()) return 1;
        else
            {
                if (first.calculateSquare()==second.calculateSquare()) return 0;
                else return -1;
            }

    }
}
