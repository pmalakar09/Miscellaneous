use strict;
use warnings;
use Data::Dumper;

sub main{
	my $csvFile='CSV.csv';
	unless(open(IFH,$csvFile)){
		die "Unable to open '$csvFile'\n";
	}
	my @storage=();
	<IFH>;
	while(my $file=<IFH>){
		my $cmp=chomp $file;
		print "CHOMP: $cmp\n";
		my @files=split /\s*,\s*/,$file;
		#print "\nDUMPER VALUE:\n".Dumper(@files);
		#print join '|',@files;
		#push @storage,$file;
		push @storage,\@files;
	}
	print"STORAGE: @storage\n";
	print $storage[0][1]."\n";
	print Dumper(@storage);
}
main();