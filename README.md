# 2018-Offseason

## Gradle Commands

- ```./gradlew test``` - Run all unit tests.
- ```./gradlew build``` - Build robot code.
- ```./gradlew deploy``` - Build & deploy robot code.
- ```./gradlew riolog [-Pfakeds]``` - Launch RoboRIO console. Optional param if not connected to DS.

- ```./gradlew smartDashboard``` - Launch SmartDashboard.
- ```./gradlew shuffleboard``` - Launch Shuffleboard dashboard.

- ```./gradlew eclipse``` - Generate files for Eclipse.
- ```./gradlew idea``` - Generate files for IntelliJ IDEA.

- ```./gradlew cleanEclipse``` - Delete Eclipse-specific files.
- ```./gradlew cleanIdea``` - Delete IDEA-specific files.

- ```./gradlew tasks [--all]``` - Show all the commands you can run.

Other GradleRIO information can be found [here](https://github.com/wpilibsuite/GradleRIO "GradleRIO Github").

## Git Commands

- ```git clone https://github.com/FRC1640/2018-Offseason.git``` - Clone this repository to your local pc.

- ```git checkout [branch_name]``` - Checkout a branch with name "branch_name."
- ```git branch -l``` - List local branches on your computer.
- ```git branch -r``` - List remote branches.
- ```git branch -d [branch_name]``` - Delete branch with the name "branch_name."

- ```git add [files]``` - Stage files to commit. "files" can be a comma-separated list of file names, or "*" to add all modified files.
- ```git commit -m "message"``` - Commit the currently staged files to git, with the message "message."
- ```git push``` - Synchronize the committed files to GitHub (or other remote location).