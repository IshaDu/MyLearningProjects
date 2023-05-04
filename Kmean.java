package numbers.kmean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

class CSVFileData{
	List<String> row =new ArrayList<String>();
	List<String> rowHeadings =new ArrayList<String>();
	List<ArrayList<String>> wholeFile = new ArrayList<ArrayList<String>>();
	
	public List<String> getRowHeadings() {
		return rowHeadings;
	}
	public void setRowHeadings(List<String> rowHeadings) {
		this.rowHeadings = rowHeadings;
	}
	public List<String> getRow() {
		return row;
	}
	public void setRow(List<String> row) {
		this.row = row;
	}
	public List<ArrayList<String>> getWholeFile() {
		return wholeFile;
	}
	public void setWholeFile(List<ArrayList<String>> wholeFile) {
		this.wholeFile = wholeFile;
	}
	public void displayCSVFileData()
	{
		Scanner scanNewChoice= new Scanner(System.in);
		System.out.println("Do you want to view the csv file contents (Press Y/y: if yes): ");
		String choice = scanNewChoice.next();
		if(choice.equals("y") || choice.equals("Y")) 
		{
			for(int i=0;i<wholeFile.size();i++)
				System.out.println(" -> "+wholeFile.get(i));
		}
		scanNewChoice.close();
	}
	
	public void writeDataToCSVFile(List<String> rowHeadings,List<ArrayList<String>> dataToWriteOnCSVList) {
		// C:/Users/ishad/Documents/Isha/ProductInfo - Copy.csv
		//System.out.println("dataToWriteOnCSVList: -----> "+dataToWriteOnCSVList);
		File file = new File("C:/Users/ishad/Documents/Isha/ProductInfoClusterKMaean.csv");
		try {
			FileWriter outputfile = new FileWriter(file);
			
			int count = 0;
			for(ArrayList<String> arrayList: dataToWriteOnCSVList) {
				//System.out.println("arraylistInside:--> "+arrayList);
				for(int i=0;i<arrayList.size();i++) {
					StringBuilder builder =  new StringBuilder();
					if(i==0 && count==0) {
						count = 1;	
						builder.append("\"");
						for(int j=0;j<rowHeadings.size();j++){
							builder.append(rowHeadings.get(j));
							builder.append("\"");
							if(j != rowHeadings.size()-1) {
								builder.append(",");
								builder.append("\"");
							}
						}
						builder.append("\n");
					}
					builder.append("\"");
					builder.append(arrayList.get(i));
					builder.append("\"");
					if (i != arrayList.size() - 1) {
						builder.append(',');
	                }
					if(i==arrayList.size()-1)
						builder.append("\n");
					outputfile.write(builder.toString());
					//System.out.println("builder---> "+builder);
				}
				
			}
			outputfile.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//CSVWriter writer = new CSVWriter(outputfile);
		
		
		  
	}
	
}

class ReadCSVData{
	String pathOfCSVFile;
	public ReadCSVData(String pathOfCSVFile) {
		super();
		this.pathOfCSVFile = pathOfCSVFile;
	}
	public List<ArrayList<String>> getCSVData() {
		Scanner sc;
		CSVFileData csvFileData = new CSVFileData();
		try {
			sc = new Scanner(new File(pathOfCSVFile));
			sc.useDelimiter(",");
			String[] s = null;
			while(sc.hasNext()) {
				s = sc.nextLine().split(",");
				// System.out.println("Length of a record is: "+s.length); 
				List<String> record = new ArrayList<String>();
				List<String> heading = new ArrayList<String>();
				for(int i=0;i<s.length;i++) { 
					if(i==0)
						heading.add(s[i]);
					record.add(s[i]);
				}
				csvFileData.setRow(record);
				csvFileData.setRowHeadings(heading);
				csvFileData.wholeFile.add((ArrayList<String>) csvFileData.getRow());
		    }  
			//csvFileData.displayCSVFileData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return csvFileData.getWholeFile();
	}	
}
 
class Centroid{
	List<ArrayList<String>> centroid = new ArrayList<ArrayList<String>>();
	List<String> centroidRecord = new ArrayList<String>();

	public List<String> getCentroidRecord() {
		return centroidRecord;
	}
	public void setCentroidRecord(List<String> centroidRecord) {
		this.centroidRecord = centroidRecord;
	}
	public List<ArrayList<String>> getCentroid() {
		return centroid;
	}
	public void setCentroid(List<ArrayList<String>> centroid) {
		this.centroid = centroid;
	}
	public void addCentroidToList(ArrayList<String> list) {
		this.centroid.add((ArrayList<String>) list);
	}
	public void updateCentroidToList(ArrayList<String> oldList,ArrayList<String> newlist) {
		List<ArrayList<String>> tempcentroidList = new ArrayList<ArrayList<String>>();
		tempcentroidList.addAll(this.centroid);
		for(int i=0;i<tempcentroidList.size();i++) {
			if(tempcentroidList.get(i).equals(oldList)) {
				tempcentroidList.get(i).clear();
				tempcentroidList.get(i).addAll(newlist);
			}
		}
	}
 }

 class BigCluster{
	Map<Integer,List<ArrayList<String>>> bigCluster = new LinkedHashMap<Integer, List<ArrayList<String>>>();
	public Map<Integer, List<ArrayList<String>>> getBigCluster() {
		return bigCluster;
	}
	public void setBigCluster(Map<Integer, List<ArrayList<String>>> bigCluster) {
		this.bigCluster = bigCluster;
	}
}

public class Kmean {
	public static void main(String[] args) {
		// C:/Users/ishad/Documents/Isha/RCaseStudy/RCaseStudy2/FitabaseData/dailyActivity_merged.csv
		// C:/Users/ishad/Documents/Isha/RCaseStudy/RCaseStudy2/FitabaseData/weightLogInfo_merged.csv
		// C:/Users/ishad/Documents/Isha/RCaseStudy/RCaseStudy3/AmazonBestSellingBooks/bestsellers_with_categories.csv
		// C:/Users/ishad/Documents/Isha/ProductInfo.csv
		// C:/Users/ishad/Documents/Isha/smaple1.csv
		Scanner sc = new Scanner(System.in);
		//STEP 1 : Reading the CSV File
		System.out.println("Enter path of the CSV file: ");
		String path = sc.nextLine();
		ReadCSVData readCSVData = new ReadCSVData(path);
		List<ArrayList<String>> wholeFile = new ArrayList<ArrayList<String>>();
		wholeFile = readCSVData.getCSVData();
		List<String> heading = new ArrayList<String>();
		heading.addAll(wholeFile.get(0));
		//System.out.println("heading is: "+heading);
    	sc.reset();
		try {
			//Step 2: Reading the value of k : Number of clusters to be made
			System.out.println("Enter the value of k (Number of clusters to be made): ");
			String k = sc.nextLine();
			
			//Step 3: SET INITIAL CENTROID AND ADD FIRST/INITIAL CENTROID/POINT TO THE CLUSTERS 
			Centroid centroid=new Centroid();
			BigCluster bigCluster = new BigCluster();
			//setting initial points in cluster and initial points in centroid
			Map<Integer,List<ArrayList<String>>> clusterMap =new LinkedHashMap<Integer, List<ArrayList<String>>>();
			List<ArrayList<String>> listOfPoints = new ArrayList<ArrayList<String>>();
			for(int i=0;i<Integer.parseInt(k);i++) {
				centroid.setCentroidRecord(wholeFile.get(i+1));
				centroid.addCentroidToList((ArrayList<String>) centroid.getCentroidRecord());
				listOfPoints = new ArrayList<ArrayList<String>>();
				listOfPoints.add((ArrayList<String>) centroid.getCentroidRecord());
				clusterMap.put(i+1, listOfPoints);
				bigCluster.setBigCluster(clusterMap);
			}
			//System.out.println("centroids are: "+centroid.getCentroid());
			//System.out.println("bigCLuster is ->"+bigCluster.getBigCluster());
		
			//Step 4: Find Euclidian Distance
			double euclidianDistance[]=new double[Integer.parseInt(k)];//Stores the euclidianDistance calculated for each record from the centroid	
			//This Map will store the record as key and its euclidian distance from centroid as its value
			Map<ArrayList<String>,Double> distanceComparisonMap = new LinkedHashMap<ArrayList<String>,Double>();
			//big loop Start
			for(int i=Integer.parseInt(k)+1;i<wholeFile.size();i++) {
				for(int j=0;j<Integer.parseInt(k);j++) {
					euclidianDistance[j] = EuclidianDistance(wholeFile.get(i),centroid.getCentroid().get(j));
					distanceComparisonMap.put(centroid.getCentroid().get(j), euclidianDistance[j]);
				}
			
				//Step 5: calculating the new centroid record 	
				/* sortedMap stores distanceComparisonMap.The least distance value from centroid is used 
				 * to calculate new centroid record by finding mean */
				Map<ArrayList<String>,Double>  sortedMap = (Map<ArrayList<String>, Double>) distanceComparisonMap.entrySet()
							  							.stream().sorted(Map.Entry.comparingByValue()).collect(Collectors
							  							.toMap(Map.Entry::getKey, Map.Entry::getValue,
							  							(oldValue,newValue)-> oldValue,LinkedHashMap::new));
				// getting the first key which is first point to be added to the fist cluster as its distance is shortest from the first point in cluster 0
				ArrayList<String> key = sortedMap.keySet().stream().findFirst().get();

				//Calculating new centroid in newKey
				ArrayList<String> newKey = new ArrayList<String>();
				for(int x=0;x<key.size();x++) { 
					Double div = ((Double.parseDouble(key.get(x)) + Double.parseDouble(wholeFile.get(i).get(x)))/2);
					Integer division = div.intValue();
					newKey.add(division.toString());
				}
			
				//Step 6: Updating the centroid records with the new calculated key 
				centroid.updateCentroidToList(key, newKey);
			 
				//Step 7: Putting least distance key value that is centroidRecord value to the cluster	  
				for (Map.Entry<Integer,List<ArrayList<String>>> entry : bigCluster.getBigCluster().entrySet()) {
		          for(int x=0;x<entry.getValue().size();x++) {
		        	  if(key.equals(entry.getValue().get(x))) {
		        		  entry.getValue().add(wholeFile.get(i));
		        	  }
		          }
		          System.out.println("Key is = " +entry.getKey()+ ", Value size now is = "+entry.getValue().size()+", Value now is = " + entry.getValue());
				}
				System.out.println("bigCluster now is: "+bigCluster.getBigCluster());
				
				//Step 8: Write to the CSV file
				CSVFileData csvFileData = new CSVFileData();
				List<ArrayList<String>> jointArrayList = new ArrayList<ArrayList<String>>();
				for(List<ArrayList<String>> arrayList  :bigCluster.getBigCluster().values()) {
					//System.out.println("arrayList is: "+arrayList);
					jointArrayList.addAll(arrayList);
				}
				//System.out.println("jointArrayList is: "+jointArrayList);
				csvFileData.writeDataToCSVFile(heading,jointArrayList);
				
				System.out.println("**************************************************************************************");
		    }//big loop ends
		}catch(Exception e) {
			e.printStackTrace();
		}
		sc.close(); 
	}

	
	private static double EuclidianDistance(ArrayList<String> wholeFileRecordParam, ArrayList<String> centroidRecordParam) {
		List<String> wholeFileRecord = new ArrayList<String>();
		List<String> centroidRecord = new ArrayList<String>();
		wholeFileRecord.addAll(wholeFileRecordParam);
		centroidRecord.addAll(centroidRecordParam);
		double sum = 0 ;
		double distance = 0 ;
		double product;
		for(int i=3;i<wholeFileRecord.size();i++) {
			product = (Double.parseDouble(centroidRecord.get(i))-Double.parseDouble(wholeFileRecord.get(i)))
					 *(Double.parseDouble(centroidRecord.get(i))-Double.parseDouble(wholeFileRecord.get(i)));
			sum = sum + product;
		}
		distance = Math.sqrt(sum);
		return distance;
	}

}
