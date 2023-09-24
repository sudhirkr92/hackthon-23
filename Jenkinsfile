pipeline {
    agent any

    stages {
        stage('GenerateFiles') {
            steps {
               bat 'sh -x ./script/transform.sh'
            }
        }
    }
}
