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
                //DOCKER_HUB_LOGIN = credentials('sudhirkr92-dockerhub-token')
		DOCKERHUB_CREDENTIALS = credentials('sudhirkr92-dockerhub-token')    
            }
            steps {
                //bat "docker login -u sudhirkr92 --password=$DOCKER_HUB_LOGIN"
		sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'    
                //sh './gradlew dockerPush -PdockerHubUsername=$DOCKER_HUB_LOGIN_USR'
                //echo "HelloWorld"
		 bat "docker push sudhirkr92/hackthon-23:latest"  
		 bat "docker logout"  
            }
        }
        stage('Deploy to AWS') {
             steps {
                sh "scp -i C:/Users/132537866/aws/hack-23-key.pem ./script/deploy.sh ec2-user@ec2-13-233-12-165.ap-south-1.compute.amazonaws.com:~/"
                sh "ssh -i C:/Users/132537866/aws/hack-23-key.pem ec2-user@ec2-13-233-12-165.ap-south-1.compute.amazonaws.com chmod +x deploy.sh"
                sh "ssh -i C:/Users/132537866/aws/hack-23-key.pem ec2-user@ec2-13-233-12-165.ap-south-1.compute.amazonaws.com ./deploy.ssh"
        }
            }
        }
}
