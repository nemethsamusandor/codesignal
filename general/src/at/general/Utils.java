package at.general;

public class Utils
{
    public static boolean compareArrays(int[][] array1, int[][] array2) {
        if (array1 != null && array2 != null)
        {
            if (array1.length != array2.length)
            {
                return false;
            }
            else
            {
                for (int i = 0; i < array2.length; i++)
                {
                    for (int j = 0; j < array2.length; j++)
                    {
                        if (array2[i][j] != array1[i][j])
                        {
                            return false;
                        }
                    }
                }
            }
        }
        else
        {
            return false;
        }
        return true;
    }
}
