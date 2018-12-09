package sort_find;

public class Sort {
	


	Sort(String arr[],int n)
	{
		String temp;
		for(int i=0;i<n;i++)
         {
			for(int j=i+1;j<n;j++)
			if(arr[i].compareTo(arr[j])>0)
			{
				temp=arr[i];arr[i]=arr[j];
				arr[j]=temp;
			}
			}}}

	

