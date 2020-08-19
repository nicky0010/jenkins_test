pipeline {
    agent { node { label 'master' } } 
    stages {
        stage('write file') {
            steps {
                deleteDir()
                writeFile(file: "${pwd()}@script/jenkinsfiles/nicky-artifact/envs/output.txt", text: "${OUTPUT_TEXT}")
            }
        }
    }
}
