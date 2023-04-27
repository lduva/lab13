import java.io.*;
import java.util.*;

public class lab13 
{
	
	public static ArrayList<Integer> list = new ArrayList<>();
	
	public void readData(String filename)
	{
		if( list.size() == 0 )
		{
			try 
			{
				BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(new File("lab13_input_data.txt"))));
				String line = "";
				while( (line = input.readLine()) != null )
				{
					list.add(Integer.valueOf(Integer.parseInt(line)));
				}
				input.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public long getTotalCount()
	{
		ArrayList<Integer> output = list;
		return output.stream().count();
	}
	
	public long getOddCount()
	{
		ArrayList<Integer> output = list;
		return output.stream().filter(x -> x % 2 != 0).count();
	}
	
	public long getEvenCount()
	{
		ArrayList<Integer> output = list;
		return output.stream().filter(x -> x % 2 == 0).count();
	}
	
	public long getDistinctGreaterThanFiveCount()
	{
		ArrayList<Integer> output = list;
		return output.stream().filter(x -> x > 5).distinct().count();
	}
	
	public Integer[] getResult1()
	{
		ArrayList<Integer> output = list;
		return output.stream().filter(x -> x > 5).filter(x -> x < 50).filter(x -> x % 2 == 0).sorted().toArray(Integer[]::new);
	}
	
	public Integer[] getResult2()
	{
		ArrayList<Integer> output = list;
		return output.stream().map(x -> x*x*3).limit(50).toArray(Integer[]::new);
	}
	
	public Integer[] getResult3()
	{
		ArrayList<Integer> output = list;
		return output.stream().filter(x -> x % 2 != 0).map(x -> x*2).sorted().skip(20).distinct().toArray(Integer[]::new);
	}
}
