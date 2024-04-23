pipeline {
  agent any
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
          sh 'docker buildx build --platform linux/amd64 -t students .'
        }
      }
      stage('Login to Docker Hub') {
        steps {
          withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials-id', usernameVariable: 'DOCKERHUB_USERNAME', passwordVariable: 'DOCKERHUB _PASSMORD' )]) {
            sh "docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD"
          }
        }
      }
      stage('Pushing Docker image') {
        steps {
          sh 'docker push nreddyre/students'
        }
      }
      stage('Deployment on k8') {
        steps {
          sh 'kubectl rollout restart deployment/deploy1'
        }
      }
    }
}

