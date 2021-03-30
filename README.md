# json_reader_Kruglov

Create and print out case classes from json-formatted strings

## Accessing the library

1. Build the fat JAR  
   ```
   sbt assembly
   ```

2. Submit the application to Spark
   ```
   spark-submit --master "local[*]" \
   --class com.example.JsonReader \
   ./target/scala-2.12/json_reader_Kruglov-assembly-0.0.1.jar \
   ./data/winemag-data-130k-v2.json
   ```
   
