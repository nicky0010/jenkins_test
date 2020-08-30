pipeline {
	agent any
	stages {
		stage('Publish') {
			steps {
				script {
					echo "${workspace}"
					echo "${pwd()}"
					commonProperties = readYaml file: "${pwd()}@script/jenkinsfiles/nicky-artifact/envs/common.yml"
					props = commonProperties.props
					mavenSetting = "${pwd()}@script/${props.mavenSettingXmlPath}"
				}
			}
		}
	}
}
