pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'jdk'
    }
    stages {
        stage('Build') {
            steps {
                sh 'cd backend && mvn package -DskipTests'
		    }
        }
        stage('Test') {
            steps {
                sh 'cd backend && mvn sonar:sonar -Dsonar.host.url=http://206.189.181.197:9000 -Dsonar.login=ef0f4b64121a9b8ddb72eb7433c04177262c612b'
            }
        }
        stage('Desploy') {
            steps {
                sh 'cd backend/target && java -jar MINGESO-1.0-SNAPSHOT.jar'
            }
        }
    }
}