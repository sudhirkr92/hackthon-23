#!/bin/bash

# Path to the text file
req_mapping_file_path="req.txt"

# mapping instructions
req_mapping_contents=$(<"$req_mapping_file_path")

#inline_mapping_contents=$(echo "$mapping_contents" | sed ':a;N;$!ba;s/\n/\\n/g')

# Call the GPT-3.5 API to generate Java code
req_map=$(curl -X POST -H "Content-Type: application/json" \
  -H "Authorization: Bearer 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" \
  -d "{
		 \"model\": \"gpt-3.5-turbo\",
	     \"messages\": [{\"role\": \"user\", \"content\": \"$req_mapping_contents\"}]
	  }" \
  "https://api.openai.com/v1/chat/completions" \
  |awk -F\" '
		$2=="content" {
				print $0
				}' )

	
req_map_code=$(echo "$req_map" | sed -e 's/\\n/\n/g' -e 's/\\\"/\"/g' | sed -n '/```java/,/```/p' | sed '/```java/d; /```/d')

# Store the generated Java code in a Java file
echo "$req_map_code" > MapRequest.java
#echo "$req_map_code" > "\hackthon-23\send-details-service\src\main\java\com\transform\ai\senddetailsservice\MapRequest.java"


res_mapping_file_path="res.txt"

res_mapping_contents=$(<"$res_mapping_file_path")

res_map=$(curl -X POST -H "Content-Type: application/json" \
  -H "Authorization: Bearer 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" \
  -d "{
		 \"model\": \"gpt-3.5-turbo\",
	     \"messages\": [{\"role\": \"user\", \"content\": \"$res_mapping_contents\"}]
	  }" \
  "https://api.openai.com/v1/chat/completions" \
  |awk -F\" '
		$2=="content" {
				print $0
				}' )

res_map_code=$(echo "$res_map" | sed -e 's/\\n/\n/g' -e 's/\\\"/\"/g' | sed -n '/```java/,/```/p' | sed '/```java/d; /```/d')

# Store the generated Java code in a Java file
echo "$res_map_code" > MapResponse.java
#echo "$req_map_code" > "\hackthon-23\send-details-service\src\main\java\com\transform\ai\senddetailsservice\MapResponse.java"