pipeline {
  agent any
  tools {
    jdk 'Java21'
    maven 'Haven3'
  }
  environment {
    DOCKERHUB_CREDENTIALS = credentials ('dockerhub')
    }
    stages {
      stage ('Build') {
        steps {
          sh 'mvn clean package'
        }
      }
      stage( 'Build Docker image'){
        steps {
          sh 'docker buildx build --platform linux/amd64 -t swe-backend .'
        }
      }
      stage('Login to Docker Hub') {
        steps {
          withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials-id', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB _PASSMORD' )]) {
            sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
          }
        }
      }
      stage('Push Docker image') {
        steps {
          sh 'docker push nreddyre/students'
        }
      }
      stage('Deployment') {
        steps {
          sh 'kubectl rollout restart deployment/deploy1'
        }
      }
    }
}
