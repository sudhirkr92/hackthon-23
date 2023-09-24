pipeline {
    agent any

    stages {
        stage('GenerateFiles') {
            steps {
               sh -x ./script/transform.sh
            }
        }
    }
}
