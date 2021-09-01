pipeline {

    agent any

    environment {
        fileName = "output.txt"
    }

    stage('delete workspace') {
        steps {
            deleteDir()
        }
    }

    stages {
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
