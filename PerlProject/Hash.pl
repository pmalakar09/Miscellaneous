use strict;
use warnings;
use Data::Dumper;
$| = 1;

sub main {
	my %myHash = (
		"1" => "Monday",
		"2" => "Tuesday",
		"3" => "Wednesday",
		"4" => "Thursday",
		"5" => "Friday",
		"6" => "Saturday",
		"7" => "Sunday",
	);

	print $myHash{2} . "\n";

	print Dumper(%myHash);

	my @keys = keys %myHash;
	print "KEYS: @keys\n";

	# Iterating over Hashes - Method 1
	for my $value (@keys) {
		print "FOR LOOP: $value : $myHash{$value}\n";
	}

	# Iterating over Hashes - Method 2
	while ( my ( $key, $value ) = each %myHash ) {
		print "WHILE LOOP: $key :: $value\n";
	}
}
main();
