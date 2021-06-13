package by.training.service.task11;

import by.training.entity.Triangle;

public class CompareTriangle {

    /**
     * Function compare triangles
     * @param first triangle
     * @param second first triangle
     * @return 1 if First triangle larger second
     *         0 equal
     *         -1 if Second triangle larger first
     */

    public static int compareSquare(Triangle first, Triangle second)
    {

        if (TriangleOperation.calculateSquare(first)>TriangleOperation.calculateSquare(second)) return 1;
        else
            {
                if (TriangleOperation.calculateSquare(first)==TriangleOperation.calculateSquare(second)) return 0;
                else return -1;
            }

    }
}
