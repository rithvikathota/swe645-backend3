pipeline {
    agent any
    
    environment {
        DOCKER_HUB_CREDENTIALS = credentials('docker')
        // KUBECONFIG = credentials('kube-config-cred-hw3')
        // dockerImage=''
    }

    stages {
        stage('Build the image') {
            steps {
                script {
                    checkout scm
                    // dockerImage= docker.build('banudeep/hw2:latest' + '${BUILD_NUMBER}')
                    sh 'docker build -t nreddyre/students:latest:${BUILD_NUMBER} .'
                }
            }
        }

        stage('Push to Docker Hub') {
            steps {
                script {
                
                    sh "docker login -u $DOCKER_HUB_CREDENTIALS_USR -p $DOCKER_HUB_CREDENTIALS_PSW"
                    // dockerImage.push()
                    sh 'docker push nreddyre/students:latest:${BUILD_NUMBER}'
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl set image deployment/deploy1 container-0=nreddyre/students:latest -n default'
			    sh 'kubectl rollout restart deploy deploy1 -n default'
            }
        }
    }
}

 

// pipeline{
//     agent any
//     environment {
// 		DOCKERHUB_CREDENTIALS=credentials('dockerhub')
// 	}
//   stages{
//     steps {
//         sh 'mvn clean install'
//       }
//       post {
//         success {
//           archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
//         }
//       }
//     }
//     stage('Login') {
//       steps {
//         sh 'echo $DOCKERHUB_CREDENTIALS_PSW |docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
//        }
//     }
//     stage("Push image to docker hub"){
//       steps {
//         sh 'docker push nreddyre/students:latest'
//       }
//     }
//         stage("deploying on k8")
// 	{
// 		steps{
// 			sh 'kubectl set image deployment/deploy1 container-0=nreddyre/students:latest -n default'
// 			sh 'kubectl rollout restart deploy deploy1 -n default'
// 		}
// 	} 
//   }
 
//   post {
// 	  always {
// 			sh 'docker logout'
// 		}
// 	}    
// }
