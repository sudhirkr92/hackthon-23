pipeline {
    agent any
    stages {
        stage("Generate Files") {
            steps {
                echo "Generating Java Files from ChatGPT API calls"    
        	bat  "sh -x ./script/transform.sh"
            }
        }

        stage("Commit Generated Files") {
            steps {
                echo "Staging the generated files and commiting in git"
                bat "git stash"  
		bat "git checkout main"
                bat "git stash pop"  
                bat "git add ./send-details-service/src/main/java/com/transform/ai/senddetailsservice/MapRequest.java"
		bat "git add ./send-details-service/src/main/java/com/transform/ai/senddetailsservice/MapResponse.java"
                bat "git commit -m 'AIGeneratedFiles'"
            }
        }

        stage("Push to Repository") {
            steps {
                withCredentials([gitUsernamePassword(credentialsId: 'sudhirkr92-github-token', gitToolName: 'Default')]) {
		     echo "Pushing to remote GitHub Repo"
	              bat "git pull origin main"		
                      bat "git push -u origin main --force"
                 }
            }
        }

        stage("Sync Repository") {
            steps {
                    echo "Sync working directory with remote GitHub Repo"
                    bat "git pull origin main"
		    bat "git status"	 
            }
        }
        stage('Build Docker image') {
            steps {
                echo "Building the docker Image based on Dockerfile"
		bat "cd send-details-service & dos2unix mvnw & docker build -t sudhirkr92/hackthon-23 ."
            }
        } 

        stage('Push Docker image') {
            environment {
		DOCKERHUB_CREDENTIALS = credentials('sudhirkr92-dockerhub-token')    
            }
            steps {
		 echo "Shiping the Docker Image to DockerHub"    
		 sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'    
		 bat "docker push sudhirkr92/hackthon-23:latest"  
		 bat "docker logout"  
            }
        }
        stage('Deploy to AWS') {
             steps {
                echo "Deploying the Docker Image on AWS -EC2"  
                build job: "Deploy", wait: true
              }
           }
       }
}
