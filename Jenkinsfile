pipeline {
    agent any
    stages {
        stage("Generate Files") {
            steps {
               //sh "./script/transform.sh"
		echo "HelloWorld"    
            }
        }

        stage("Commit Generated Files") {
            steps {
		//bat "git checkout main"    
                //bat "git add ./send-details-service/src/main/java/com/transform/ai/senddetailsservice/MapRequest.java"
		//bat "git add ./send-details-service/src/main/java/com/transform/ai/senddetailsservice/MapResponse.java"
                //bat "git commit -m 'AIGeneratedFiles'"
		echo "HelloWorld"
            }
        }

        stage("Push to Repository") {
            steps {
               //withCredentials([gitUsernamePassword(credentialsId: 'sudhirkr92-github-token', gitToolName: 'Default')]) {
	            //bat "git pull origin main"		
                    //bat "git push -u origin main"
                    echo "HelloWorld"
               // }
            }
        }

        stage("Clone Repository") {
            steps {
                //git(
                   // url: "https://github.com/sudhirkr92/hackthon-23.git",
                   // branch: "main"
                    echo "HelloWorld"
               // )
            }
        }
        stage('Build Docker image') {
            steps {
                //sh './gradlew docker'
                //echo "HelloWorld"
		//bat "dos2unix mvnw"    
		bat "cd send-details-service & dos2unix mvnw & docker build -t sudhirkr92/hackthon-23 ."
                //bat "docker build -t send-details-service ."
            }
        } 

        stage('Push Docker image') {
            environment {
                DOCKER_HUB_LOGIN = credentials('sudhirkr92-dockerhub-token')
            }
            steps {
                bat "docker login --username=sudhirkr92 --password-stdin"
                //sh './gradlew dockerPush -PdockerHubUsername=$DOCKER_HUB_LOGIN_USR'
                //echo "HelloWorld"
		 bat "docker push sudhirkr92/hackthon-23:latest"  
		 bat "docker logout"  
            }
        }
        stage('Deploy to AWS') {
           //environment {
                //DOCKER_HUB_LOGIN = credentials('docker-hub')
           // }
            steps {
                //withAWS(credentials: 'aws-credentials', region: env.AWS_REGION) {
                    //sh './gradlew awsCfnMigrateStack awsCfnWaitStackComplete -PsubnetId=$SUBNET_ID -PdockerHubUsername=$DOCKER_HUB_LOGIN_USR -Pregion=$AWS_REGION'
                    echo "HelloWorld"
                }
            }
        }
}
