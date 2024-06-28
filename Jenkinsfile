pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Corrected sh step with proper string termination
                    sh 'mvn deploy'
                }
            }
        }
        // stage('Test') {
        //     steps {
        //         script {
        //             sh 'mvn test'
        //         }
        //     }
        // }
    }
}
