pipeline {
    agent any
    stages {
        stage("Generate Files") {
            steps {
               sh "./script/transform.sh"
            }
        }

        stage("Commit Generated Files") {
            steps {
                sh "git add ./send-details-service/src/main/java/com/transform/ai/senddetailsservice/MapRequest.java"
		sh "git add ./send-details-service/src/main/java/com/transform/ai/senddetailsservice/MapResponse.java"
                sh "git commit -m 'Added AI generated Java Files from Jenkins Pipeline'"
            }
        }

        stage("Push to Repository") {
            steps {
                withCredentials([gitUsernamePassword(credentialsId: 'ssbostan-github-token', gitToolName: 'Default')]) {
                    sh "git push -u origin main"
                }
            }
        }

        stage("Clone Repository") {
            steps {
                git(
                    url: "https://github.com/sudhirkr92/hackthon-23.git",
                    branch: "main"
                )
            }
        }
        stage('Build Docker image') {
            steps {
                //sh './gradlew docker'
                echo "HelloWorld"
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
