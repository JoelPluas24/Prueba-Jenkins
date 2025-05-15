pipeline {
    agent any

    tools {
        maven 'Maven' // Asegúrate que este nombre coincide con el definido en Jenkins
    }

    stages {
        stage('Clean Workspace') {
            steps {
                deleteDir()
            }
        }

        stage('Build') {
            steps {
                bat 'mvn -B -DskipTests clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
                unsuccessful {
                    echo 'Algunas pruebas fallaron.'
                }
            }
        }

        stage('Deliver') {
            steps {
                bat 'jenkins\\scripts\\deliver.bat'
            }
        }

        stage('Archive Artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}
