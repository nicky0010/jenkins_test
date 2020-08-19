pipeline {
	agent any
	stages {
		stage('Publish') {
			steps {
				deleteDir()
				script {
					commonProperties = readYaml file: "${pwd()}@script/jenkinsfiles/nicky-artifact/envs/common.yml"
					props = commonProperties.props
					mavenSetting = "${pwd()}@script/${props.mavenSettingXmlPath}"
				}
			}
		}
	}
}
