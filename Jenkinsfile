pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                witMaven(maven : 'maven_3_9_8') {
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Test') {
            steps {
                witMaven(maven : 'maven_3_9_8') {
                    sh 'mvn test'
                }
            }
        }
        stage('Deploy') {
            steps {
                witMaven(maven : 'maven_3_9_8') {
                    // Corrected sh step with proper string termination
                    sh 'mvn deploy'
                }
            }
        }
    }
}
