# This script updates AndroidManifiest.xml file
# - Updates android:versionCode adding +1 to the version

# Reading arguments
if ARGV.length < 1
  puts 'File as argument required'
  exit
end

# Reading file
fileName = ARGV[0]
if File.exists?(fileName)
  begin
    # Read the file
    manifiest = File.read(fileName)

    # Get the version
    versionCode = /android\:versionCode\=\"([0-9]*)\"/.match(manifiest)
    versionName = /android\:versionName\=\"(.*)\"/.match(manifiest)
    return unless versionCode
    return unless versionName
    version_line = versionCode[0]
    version_int = versionCode[1].to_i
    puts version_int if ARGV[1] == "versionCode"
    versionName_line = versionName[0]
    versionName_str = versionName[1].to_s
    puts versionName_str if ARGV[1] == "versionName"
  rescue Exception => e
    puts("Something happened updating version of AndroidManifest.xml: " + e)
  end
end
