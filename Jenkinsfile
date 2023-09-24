pipeline {
    agent any

    stages {
        stage('GenerateFiles') {
            steps {
               sh script/transform.sh
            }
        }
    }
}
