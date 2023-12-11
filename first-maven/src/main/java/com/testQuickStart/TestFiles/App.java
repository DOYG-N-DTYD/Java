package com.testQuickStart.TestFiles;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import com.testQuickStart.DesktopSwingApp.app.SwingDesktopApplication;

public class App {
	
	public static void main(String[] args) throws Exception {
//		StringBuffer stringBuffer = new StringBuffer("<^^^>v");
//			//run();
//		List<String > list1 = new LinkedList<String>();
//		DB_engine db_engine = new DB_engine();	
//		db_engine.allData();
//		db_engine.specialQuery();
		
		//SwingDesktopApplication application = new SwingDesktopApplication();
		//application.main(args);
		}
	
	
	public static boolean check(String s) {
        int idx = 0;

        int count_y = 0;
        int count_x = 0;

        while (idx < s.length() && s.charAt(idx) == '^') {
            idx += 1;
            count_y += 1;
        }

        while (idx < s.length() && s.charAt(idx) == '<') {
            idx += 1;
            count_x += 1;
        }

        while (idx < s.length() && s.charAt(idx) == 'v') {
            idx += 1;
            count_y -= 1;
        }

        while (idx < s.length() && s.charAt(idx) == '>') {
            idx += 1;
            count_x -= 1;
        }

        return idx == s.length() && count_x == 0 && count_y == 0;
    }
	
	
	public static <E> void printCollection(Collection<E> collectionToPrint) {
		for (E e: collectionToPrint) {
			System.out.println(e);
		}
	}
	
	public static <K, V> void printCollectionHash(Map<K, V> collectionToPrint) {
		collectionToPrint.forEach((key, value) -> {
			System.out.println(key + "  " + value);
		});
	}
		
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	





//TreeSet<String> countrySet = new TreeSet<String>();
//countrySet.add("Germany");
//countrySet.add("Albania");
//countrySet.add("Georgia");
//countrySet.add("China");
//countrySet.add("China");
//System.out.println(" TreeSet ");
//printCollection(countrySet);

//HashMap<Integer, String> employeeHashMap = new HashMap<Integer, String>();
//employeeHashMap.put(24, "Mirek");
//employeeHashMap.put(18, "Ola");
//employeeHashMap.put(33, "jakub");
//employeeHashMap.put(18, "Zdislaw");
//printCollectionHash(employeeHashMap);

//LinkedList<String> linkedListCars = new LinkedList<String>();
//linkedListCars.add("audi");
//linkedListCars.add("ford");
//linkedListCars.add("merc");
//System.out.println(linkedListCars.toString());

//StringBuffer sBuffer = new StringBuffer("test");
//sBuffer.deleteCharAt(4);
//System.out.println(sBuffer);
//
//TreeMap<K, V> treeMap;
//Map<K, V> map;
//HashMap<K, V> hashMap;

//TestThread thread = new TestThread();
//thread.run();
//TestThread thread1 = new TestThread();
//thread1.run();




//	
//	System.out.println("AAAAAAAAAAAAAAAAAa");
//	int[] A = {-100,2,-50, 1, 8,3,5};
//	int[] A1 = {-100,-50};
//	Arrays.sort(A1);
//	for (int i = 0; i < A1.length; i++) {
//		System.out.println(A1[i]);
//	}
//	System.out.println(" Response " + test1(A)); 
//
//}
//public static int test1(int[] A) {
//	int resp = 0;
//	int pastNum = 0;
//	for (int i = 0; i < A.length; i++) {
//		if (A[i] < 0 ) {
//			resp = 1;
//		}
//		if (A[i] > 0) {
//			if (A[i] - pastNum > 1) {
//				return pastNum + 1;
//			} 
//			pastNum = A[i];	
//		}
//	}
//	return resp;
//}



//ZADANIE 1

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

//class Solution {
// public boolean solution(String moves) {
//     // Implement your solution here
//     return run(moves);
// }
// public boolean check(String s) {
//     int idx = 0;
//
//     int count_y = 0;
//     int count_x = 0;
//
//     while (idx < s.length() && s.charAt(idx) == '^') {
//         idx += 1;
//         count_y += 1;
//     }
//
//     while (idx < s.length() && s.charAt(idx) == '<') {
//         idx += 1;
//         count_x += 1;
//     }
//
//     while (idx < s.length() && s.charAt(idx) == 'v') {
//         idx += 1;
//         count_y -= 1;
//     }
//
//     while (idx < s.length() && s.charAt(idx) == '>') {
//         idx += 1;
//         count_x -= 1;
//     }
//
//     return idx == s.length() && count_x == 0 && count_y == 0;
// }
//
// public boolean run(String s) {
//     int tries = s.length();
//     for (int i = 0; i < tries; i++) {
//         s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
//         if (check(s)) {
//             return true;
//         }
//     }
//     return false;
// }
//}








//
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
//package com.codility.tasks.spring.healthcheck;
//
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.http.MediaType;
//
//import java.time.ZonedDateTime;
//
//@RestController
//class HealthcheckController {
//
//     @GetMapping(value = "/healthcheck", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Object> healthcheck(@RequestParam(name = "format", required = false) String format) {
//        if ("short".equals(format)) {
//            // Return a simple healthcheck response
//            return ResponseEntity.ok(Map.of("status", "OK"));
//        } else if ("full".equals(format)) {
//            // Return a detailed healthcheck response
//            ZonedDateTime currentTime = ZonedDateTime.now();
//            String currentTimeString = currentTime.format(DateTimeFormatter.ISO_INSTANT);
//            Map<String, Object> response = new HashMap<>();
//            response.put("status", "OK");
//            response.put("currentTime", currentTimeString);
//            return ResponseEntity.ok(response);
//        } else {
//            // Handle invalid or missing format parameter
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid format parameter");
//        }
//    }
//
//    @PutMapping(value = "/healthcheck")
//    public ResponseEntity<String> healthcheckPut() {
//        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Method Not Allowed");
//    }
//
//    @PostMapping(value = "/healthcheck")
//    public ResponseEntity<String> healthcheckPost() {
//        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Method Not Allowed");
//    }
//
//    @DeleteMapping(value = "/healthcheck")
//    public ResponseEntity<String> healthcheckDelete() {
//        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Method Not Allowed");
//    }
//
//}
//
//



//csvFileDAO
//package com.codility;
//
//import com.codility.event.Event;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import java.nio.file.*;
//import java.io.*;
//import java.util.*;
//
//public class CsvFileDao {
//    public CsvFileDao() {}
//
//    //private final String fileName;
//    // PropertiesFileHelper propertiesFileHelper = new PropertiesFileHelper();
//    //     this.fileName = propertiesFileHelper.csvFileNameFromProperties();
//
//    public List<Event> readAll() throws Exception {
//        String csvFileName = PropertiesFileHelper.csvFileNameFromProperties();
//        // TODO: implement
//        List<Event> events = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                events.add(CsvFileUtils.eventFromCsvLine(line));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return events;
//        //return null;
//    }
//
//    public void write(Event event) throws Exception {
//        String csvFileName = PropertiesFileHelper.csvFileNameFromProperties();
//        String csvLine = CsvFileUtils.csvLineFromEvent(event) + "\n";
//        // TODO: implement
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true)) {
//            String csvLine = CsvFileUtils.csvLineFromEvent(event);
//            writer.write(csvLine);
//            writer.newLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Event read(Long eventId) throws Exception {
//        List<Event> events = readAll();
//        // TODO: implement
//        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                Event event = CsvFileUtils.eventFromCsvLine(line);
//                if (event.getId().equals(eventId)) {
//                    return event;
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//}



//CSVFILEUTILS
//package com.codility;
//
//import java.time.LocalDateTime;
//
//import com.codility.event.Event;
//
//public class CsvFileUtils {
//    private static final String CSV_SEPARATOR = ",";
//    private static final String NEW_LINE_SEPARATOR = "\n";
//
//    public static  String csvLineFromEvent(Event event) {
//        // TODO: implement
//        return String.format("%d,%s,%s,%s,%s",
//                event.getId(),
//                event.getName(),
//                event.getDescription(),
//                event.getStart(),
//                event.getEnd());
//    }
//
//    public static Event eventFromCsvLine(String csvLine) {
//        // TODO: implement
//        String[] data = csvRow.split(",");
//        if (data.length != 5) {
//            throw new IllegalArgumentException("Invalid CSV format.");
//        }
//
//        return Event.builder()
//                .id(Long.parseLong(data[0]))
//                .name(data[1])
//                .description(data[2])
//                .start(LocalDateTime.parse(data[3]))
//                .end(LocalDateTime.parse(data[4]))
//                .build();
//    }
//}



//PropertiesFileHelper
//package com.codility;
//
//import java.io.*;
//import java.util.*;
//import com.codility.event.Event;
//
//public class PropertiesFileHelper {
//    public static String APPLICATION_PROPERTIES = "application.properties";
//    public static final String CSV_FILE_NAME_KEY = "csv.file.name";
//    public static final String DEFAULT_FILE_NAME = "default.csv";
//
//    public static String csvFileNameFromProperties() {
//        // TODO: implement
//        // NOTE: While working with this method an exception may be thrown.
//        // Please catch any Exceptions, and return DEFAULT_FILE_NAME after Exception was caught.
//        try {
//            Properties properties = new Properties();
//            FileInputStream input = new FileInputStream("application.properties");
//            properties.load(input);
//            return properties.getProperty("csv.file.name", DEFAULT_FILE_NAME);
//        } catch (IOException e) {
//            return DEFAULT_FILE_NAME;
//        }
//        //return DEFAULT_FILE_NAME;
//    }
//}












//
//
//You are given a part of Spring MVC application and your task is to build new RESTful web controller. You should implement two variants of reading the /healthcheck resource using JSON as the response data format:
//
//Method to read simple healthcheck
//
//A request to GET /healthcheck?format=short should return a simple message: "status": "OK"}
//
//Method to read detailed healthcheck
//
//A request to GET /healthcheck? format full should return the application status and current time (formatted as an ISO 8601 string):
//
//{"currentTime": "2018-06-06T21-59-362","status": "OK" })
//
//Other requirements and hints
//
//1.Performance is not assessed, focus on correctness and code quality.
//
//2. Your service is expected to handle only GET method. Other methods should return 405 status.
//
//3. If parameters' values do not match the specified possible values or if no parameter is present, you should return HTTP status code 400 ("Bad
//
//Request").
//
//4. Responses should have Content-Type header with appropriate value (application/json). 5. If you need to create multiple classes, you can use nested classes or define multiple classes in one source file.
//
//MODIFY, CHANGE CODE BELOW:
//
//package com.codility.tasks.spring.healthcheck;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.http.MediaType;
//import java.time.ZonedDateTime;
//@RestController
//class HealthcheckController {
//    @GetMapping(value = "/healthcheck")
//    public void healthcheck() {
//        return;
//    }
//    @PutMapping(value = "/healthcheck")
//    public void healthcheckPut() {
//        return;
//    }
//    @PostMapping(value = "/healthcheck")
//    public void healthcheckPost() {
//        return;
//    }
//    @DeleteMapping(value = "/healthcheck")
//    public void healthcheckDelete() {
//        return;
//    }
//
//}
