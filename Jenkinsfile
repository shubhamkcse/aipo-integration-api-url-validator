pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                withMaven(maven : 'maven_3_9_8'){
                    sh 'mvn clean compile'
                    }
            }
        }
        stage('Test') {
            steps {
                withMaven(maven : 'maven_3_9_8'){
                    sh 'mvn test'
                    }
            }
        }
        stage('Deploy') {
            steps {
                withMaven(maven : 'maven_3_9_8'){
                    sh 'mvn deploy
                    }
            }
        }
    }
}
