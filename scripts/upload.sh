echo "Going to upload apk"

BUILD_DIR_CONTENTS="$(ls ../app/build/outputs/apk)"
echo "${BUILD_DIR_CONTENTS}"

VERSION_NAME=$(ruby ./scripts/find_version.rb ./app/src/main/AndroidManifest.xml versionName)
VERSION_CODE=$(ruby ./scripts/find_version.rb ./app/src/main/AndroidManifest.xml versionCode)
RELEASE_DATE=`date '+%Y-%m-%d %H:%M:%S %z'`
RELEASE_NOTES="Build: $VERSION_NAME ($VERSION_CODE) - Uploaded: $RELEASE_DATE"

# Hockeyapp upload
response=$(curl https://rink.hockeyapp.net/api/2/apps/$HOCKEY_APP_ID/app_versions \
  -F status="2" \
  -F notify="1" \
  -F notes="$RELEASE_NOTES" \
  -F notes_type="0" \
  -F ipa="@./app/build/outputs/apk/app-production-debug.apk" \
  -H "X-HockeyAppToken: $HOCKEY_APP_TOKEN")
echo $response
