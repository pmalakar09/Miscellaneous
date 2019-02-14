use strict;
use warnings;
$|=1;

sub main(){
	my $string="The token id is : ABCD12345. Please use the same.";
	print "$string\n";
	if ($string =~ /(: \w+)/){
		print "MATCHED ID: $1";		
	}
}
main();