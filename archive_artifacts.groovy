pipeline {

    agent any

    environment {
        fileName = "output.txt"
    }

    stages {
        stage('delete workspace') {
            steps{
                deleteDir()
                script {
                    dir("working-group") {
                        git([url: "https://github.com/nicky0010/working-group.git", branch: "master", credentialsId: "30670cd3-7531-45cb-9974-716a0c49adf0"])
                    }
                }
            }
        }

        stage('write file') {
            steps {
                writeFile(file: fileName, text: "BBB")
            }
        }
    }

//    post {
//        success {
//            cleanWs()
//        }
//    }
}
