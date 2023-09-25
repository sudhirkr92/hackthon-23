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
		sh "sudo apt install dos2unix"    
		bat "cd send-details-service & docker build -t send-details-service ."
                //bat "docker build -t send-details-service ."
            }
        } 

        stage('Push Docker image') {
            //environment {
                //DOCKER_HUB_LOGIN = credentials('docker-hub')
            //}
            steps {
                //sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                //sh './gradlew dockerPush -PdockerHubUsername=$DOCKER_HUB_LOGIN_USR'
                echo "HelloWorld"
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
