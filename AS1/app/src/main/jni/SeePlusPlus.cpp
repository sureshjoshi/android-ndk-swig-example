#include "SeePlusPlus.h"

#include <algorithm>
#include <random>

using namespace SJ;

SeePlusPlus::SeePlusPlus()
{}

SeePlusPlus::~SeePlusPlus()
{}

int SeePlusPlus::Multiply( const int x, const int y )
{
    return x * y;
}

double SeePlusPlus::Multiply( const double x, const double y )
{
    return x * y;
}

std::vector< int > SeePlusPlus::RandomNumbers( const int size )
{
    // Seed a generator with a real random value, if available
    std::random_device rd;
    std::mt19937 generator( rd() );

    // Create a uniform distribution between 1 and 100
    std::uniform_int_distribution<> uniformDistribution(1, 100);

    // Fill the vector with random data
    std::vector< int > randomNumbers( size );
    for (auto& datapoint : randomNumbers)
    {
        datapoint = uniformDistribution( generator );
    }

    return randomNumbers;
}

std::vector< std::string > SeePlusPlus::Sort( const std::vector< std::string >& inStringList )
{
    std::vector< std::string > sortedList( inStringList );
    std::sort( std::begin( sortedList ), std::end( sortedList ) );
    return sortedList;
}