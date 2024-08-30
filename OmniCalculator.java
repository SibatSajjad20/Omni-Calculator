import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OmniCalculator extends JFrame {
 private JPanel mainPanel;
 private JPanel categoryPanel;
 public JPanel subcategoryPanel;

 public OmniCalculator() {
     setTitle("Omni Calculator");
     setSize(800, 600);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     mainPanel = createMainPanel();
     setContentPane(mainPanel);
 }

 private JPanel createMainPanel() {
     JPanel panel = new JPanel(new BorderLayout());
     panel.setBackground(Color.WHITE);

     JPanel centerPanel = new JPanel();
     centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
     centerPanel.setBackground(Color.WHITE);

     JLabel titleLabel = new JLabel("Omni Calculator", SwingConstants.CENTER);
     titleLabel.setFont(new Font("Poppins", Font.BOLD, 24));
     titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
     centerPanel.add(titleLabel);

     centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

     JLabel membersLabel = new JLabel("Made by:", SwingConstants.CENTER);
     membersLabel.setFont(new Font("Poppins", Font.PLAIN, 18));
     membersLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
     centerPanel.add(membersLabel);

     JLabel nameLabel1 = new JLabel("Sibat Sajjad", SwingConstants.CENTER);
     nameLabel1.setFont(new Font("Poppins", Font.PLAIN, 18));
     nameLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
     centerPanel.add(nameLabel1);

     

JButton enterButton = new JButton("Enter");
enterButton.setFont(new Font("Poppins", Font.PLAIN, 18));
enterButton.setAlignmentX(Component.CENTER_ALIGNMENT);
enterButton.addActionListener(e -> {
categoryPanel = createCategoryPanel();
setContentPane(categoryPanel);
revalidate();
repaint();
});
centerPanel.add(Box.createRigidArea(new Dimension(0, 20)));
centerPanel.add(enterButton);

panel.add(centerPanel, BorderLayout.CENTER);

return panel;
}

private JPanel createCategoryPanel() {
JPanel panel = new JPanel();
panel.setLayout(new GridLayout(4, 2, 10, 10));
String[] categories = { "Conversions", "Finance", "Maths", "Physics", "Stats", "Health", "Sports" };
for (String category : categories) {
    JButton categoryButton = new JButton(category);
categoryButton.setFont(new Font("Poppins", Font.PLAIN, 16));
categoryButton.addActionListener(new CategoryButtonListener(category));
panel.add(categoryButton);
}

return panel;
}

private JPanel createSubcategoryPanel(String category) {
JPanel panel = new JPanel();
panel.setLayout(new GridLayout(10, 3, 10, 10));

String[] subcategories = getSubcategories(category);
for (String subcategory : subcategories) {
JButton subcategoryButton = new JButton(subcategory);
subcategoryButton.setFont(new Font("Poppins", Font.PLAIN, 14));
subcategoryButton.addActionListener(new SubcategoryButtonListener(category, subcategory));
panel.add(subcategoryButton);
}

JButton backButton = new JButton("Back");
backButton.setFont(new Font("Poppins", Font.PLAIN, 16));
backButton.addActionListener(e -> {
setContentPane(categoryPanel);
revalidate();
repaint();
});
panel.add(backButton);

return panel;
}

private String[] getSubcategories(String category) {
switch (category) {
case "Conversions":
return new String[] {
"Acreage Calculator", "Area Converter", "Ares to hectares converter","Astronomical Unit Calculator",
"Decimeter to Meter Converter", "Feet and Inches Calculator", "Height in Inches Calculator",
"Inches to Fraction Calculator", "Length Converter", "Light Year Conversion","Mesh to Micron Converter",
"Pixels to Inches Converter", "Cubic Feet Calculator", "Cubic Meter Calculator","Cubic Yards to Tons Calculator","Decagram to gram converter", "Drops to ml Conversion", "oz to Cups Converter","Gallon Calculator", "Force Converter", "Inch-Pounds to Foot-Pounds Converter","Lbs to Newtons Converter","Newton Meter Calculator", "Pressure Conversion","Billion to Trillion Converter","Crore to Lakh Converter", "Crore to Million Converter", "Million to Billion Converter","Temperature Converter","Currency Converter","Weight to Volume Converter","Speed Converter","Time Zone Converter","Energy Converter","Volume to Mass Converter","Power Converter","Frequency Converter","Torque Converter","Fuel Efficiency Converter","Digital Storage Converter"
};
case "Finance":
return new String[] {
"Absence Percentage Calculator", "Accumulated Depreciation Calculator","Additional Funds Needed Calculator","Attrition Rate Calculator", "Average Collection Period Calculator","Average Fixed Cost Calculator","Bounce Rate Calculator", "Break-even Calculator",  "Interest Calculator","12-Hour Shift Pay Calculator","AGI Calculator","Alabama Tax Calculator","AMT Calculator","Mortgage Payoff Calculator","Mortgage Penalty Calculator","Mortgage Points Calculator","Mortgage Rate Calculator","Home Loan Calculator","Land Loan Calculator","Lease Calculator","Lease Mileage Calculator","Loan Calculator","Compound Interest Calculator","Loan Payment Calculator","Rule of 72 Calculator","Debt-to-Income Ratio Calculator","Capital Gains Calculator","Retirement Savings Calculator","Future Value of Investment Calculator","Loan EMI Calculator","Savings Goal Calculator","ROI Calculator","Payback Period Calculator","Dividend Yield Calculator","Debt Payoff Calculator","Savings Interest Calculator","Operating Margin Calculator","Markup Calculator","Revenue Per Employee Calculator",
"Compound Annual Growth Rate (CAGR) Calculator"
};
case "Maths":
return new String[] {
"Average Percentage Calculator", "Fraction to Percent Calculator","Decimal to Percent Converter",
"Absolute Value Equation Calculator", "Absolute Value Inequalities Calculator","Adding and Subtracting Polynomials Calculator","Absolute Change Calculator", "Absolute Value Calculator","Adding and Subtracting Fractions Calculator","Mean Calculator", "Average Rate of Change Calculator", "Bilinear Interpolation Calculator","Catenary Curve Calculator","Coordinate Grid Calculator", "Distance Calculator", "Triangulation Calculator","Unit Vector Calculator","Vector Calculator", "Adding Fractions Calculator","Decimal to Fraction Calculator","Dividing Fractions Calculator", "Equivalent Fractions Calculator","Fraction Exponent Calculator","Fraction To Decimal Converter", "Golden Ratio Calculator", "Adjoint Matrix Calculator","Cramer's Rule Calculator","Matrix Rank Calculator","Quadratic Equation Solver","Factorial Calculator","Perimeter Calculator","Area of Circle Calculator","Volume of Cylinder Calculator","Surface Area of Sphere Calculator","Permutation Calculator","Combination Calculator","Pythagorean Theorem Calculator","Exponential Growth Calculator","Logarithm Calculator","Root Mean Square (RMS) Calculator"
};
case "Physics":
return new String[] { "Force Calculator","Displacement Calculator","Friction Calculator","Ground Speed Calculator","Horizontal Projectile Motion Calculator","Trajectory Calculator","Velocity Calculator","Acceleration Calculator","Angle of Banking Calculator","Car Crash Calculator","Gravitational Force Calculator","Hooke's Law Calculator","Newton's Second Law Calculator","Normal Force Calculator","Net Force Calculator","Tension Calculator","Pressure Calculator","Reduced Mass Calculator","Impact Energy Calculator","Kinetic Energy Calculator","Potential Energy Calculator","Power-to-Weight Ratio Calculator","Recoil Energy Calculator","Signal-to-Noise Ratio Calculator","Speed of Light Calculator","Watt Converter","Work Calculator","E = mc² Calculator","Drift Velocity Calculator","Electrical Power Calculator","Electric Field Calculator","Circular Motion Calculator","Wave Speed Calculator","Buoyancy Force Calculator","Capacitance Calculator","Magnetic Force Calculator","Induced EMF Calculator","Thermal Expansion Calculator","Doppler Effect Calculator","Lens Formula Calculator","Thermodynamic Efficiency Calculator"
};
case "Stats":
return new String[] { "Mean Calculator","Accuracy Calculator","Coin Flipper","Coin Flip Probability Calculator","Coin Toss Streak Calculator","Combination Calculator","Conditional Probability Calculator","Confusion Matrix Calculator","Dice Average Calculator","Dice Probability Calculator","Dice Roller Calculator","Lottery Calculator","Monty Hall Problem Calculator","Odds Calculator","Number Summary Calculator","Average Rating Calculator","Coefficient of Variation Calculator","Median Calculator","Median Absolute Deviation Calculator","Midrange Calculator","Minimum and Maximum Calculator","Mode Calculator","Standard Deviation Calculator","Correlation Coefficient Calculator","Confidence Interval Calculator","Chi-Square Calculator","Binomial Probability Calculator" ,"Variance Calculator","Regression Line Slope Calculator","Poisson Distribution Calculator","Harmonic Mean Calculator","T-Score Calculator","Quartile Calculator","Skewness Calculator",
"Kurtosis Calculator","Covariance Calculator","Exponential Smoothing Calculator","Z-Score Calculator"};
case "Health":
return new String[] { "BMI Calculator","ABSI Calculator","Adjusted Body Weight Calculator","BAI Calculator","Body Frame Size Calculator","Body Shape Calculator","BSA Calculator","Added Sugar Intake Calculator","Calorie Deficit Calculator","Carb Calculator","Cholesterol Ratio Calculator","Karvonen Formula Calculator","Ponderal Index Calculator","Waist to Hip Ratio Calculator","Waist to Height Ratio Calculator","Daily Water Intake Calculator","Caffeine Intake Calculator","Sleep Duration Calculator","Heart Rate Zone Calculator","Body Temperature Converter","Calorie Burn Calculator","Breath Rate Calculator","Nicotine Intake Calculator","Screen Time Calculator","Basal Metabolic Rate (BMR) Calculator","Target Heart Rate Calculator","Calorie Intake Calculator","Ideal Weight Calculator","Lean Body Mass (LBM) Calculator" , "Body Water Percentage Calculator","Fat Intake Calculator","Macro Nutrient Calculator","Resting Metabolic Rate (RMR) Calculator","Healthy Body Fat Range Calculator","Smoking Risk Calculator" };
case "Sports":
return new String[] { "Batting Average Calculator","Dunk Calculator","Fielding Percentage Calculator","Magic Number Calculator","On Base Percentage Calculator","Burpee Calorie Calculator","Calories Burned Calculator","Calories Burned by Heart Rate Calculator","Elliptical Calorie Calculator","Fat Burning Zone Calculator","Hiking Calculator","Jump Rope Calorie Calculator","Running Calorie Calculator","Sauna Calories Burned Calculator","Snow Shoveling Calories Burned Calculator","Stairs Calorie Calculator","Batting Strike Rate Calculator","Bowling Average Calculator","Age Grade Calculator","Bike Cadence and Speed Calculator","Bike Gear Calculator","Bike Pace Calculator","Bench Press Calculator","Bench Press Pyramid Calculator","One-Rep Max Calculator","Pace Calculator","Vo2 Max Calculator","Golf Handicap Calculator","Protein Intake Calculator for Athletes","Cycling Power Calculator",
"Swimming Calorie Calculator","Rowing Calorie Calculator","Soccer Ball Kick Calculator","Sprint Speed Calculator","Swimming Pace Calculator","Tennis Serve Speed Calculator","Treadmill Calorie Calculator","Volleyball Spike Speed Calculator","Walking Calorie Calculator"};
default:
return new String[] {};
}
}

private class CategoryButtonListener implements ActionListener {
private String category;

public CategoryButtonListener(String category) {
this.category = category;
}

@Override
public void actionPerformed(ActionEvent e) {
subcategoryPanel = createSubcategoryPanel(category);
setContentPane(subcategoryPanel);
revalidate();
repaint();
}
}

private class SubcategoryButtonListener implements ActionListener {
private String category;
private String subcategory;

public SubcategoryButtonListener(String category, String subcategory) {
this.category = category;
this.subcategory = subcategory;

}

@Override
public void actionPerformed(ActionEvent e) {
JPanel calculatorPanel = getCalculatorPanel(category, subcategory);
setContentPane(calculatorPanel);
revalidate();
repaint();
}
}

private JPanel getCalculatorPanel(String category, String subcategory) {
switch (category) {
case "Conversions":
switch (subcategory) {
case "Acreage Calculator":
return new AcreageCalculator(this);
case "Area Converter":
return new AreaConverter(this);
case "Ares to hectares converter":
return new AresToHectaresConverter(this);
case "Astronomical Unit Calculator":
return new AstronomicalUnitCalculator(this);
case "Decimeter to Meter Converter":
return new DecimeterToMeterConverter(this);
case "Feet and Inches Calculator":
return new FeetAndInchesCalculator(this);
case "Height in Inches Calculator":
return new HeightInInchesCalculator(this);
case "Inches to Fraction Calculator":
return new InchesToFractionCalculator(this);
case "Length Converter":
return new LengthConverter(this);
case "Light Year Conversion":
return new LightYearConversion(this);
case "Mesh to Micron Converter":
return new MeshToMicronConverter(this);
case "Pixels to Inches Converter":
return new PixelsToInchesConverter(this);
case "Cubic Feet Calculator":
return new CubicFeetCalculator(this);
case "Cubic Meter Calculator":
return new CubicMeterCalculator(this);
case "Cubic Yards to Tons Calculator":
return new CubicYardstoTonsCalculator(this);
case "Decagram to gram converter":
return new DecagramtoGramConverter(this);
case "Drops to ml Conversion":
return new DropstoMlConversion(this);
case "oz to Cups Converter":
return new oztoCupsConverter(this);
case "Gallon Calculator":
return new GallonCalculator(this);
case "Force Converter":
return new ForceConverter(this);
case "Inch-Pounds to Foot-Pounds Converter":
return new InchPoundstoFootPoundsConverter(this);
case "Lbs to Newtons Converter":
return new LbstoNewtonsConverter(this);
case "Newton Meter Calculator":
return new NewtonMeterCalculator(this);
case "Pressure Conversion":
return new PressureConversion(this);
case "Billion to Trillion Converter":
return new BilliontoTrillionConverter(this);
case "Crore to Lakh Converter":
return new CroretoLakhConverter(this);
case "Crore to Million Converter":
return new CroretoMillionConverter(this);
case "Million to Billion Converter":
return new MilliontoBillionConverter(this);
case "Temperature Converter":
return new TemperatureConverter(this);
case "Currency Converter":
return new CurrencyConverter(this);
case "Weight to Volume Converter":
return new WeighttoVolumeConverter(this);
case "Speed Converter":
return new SpeedConverter(this);
case "Time Zone Converter":
return new TimeZoneConverter(this);
case "Energy Converter":
return new EnergyConverter(this);
case "Volume to Mass Converter":
return new VolumetoMassConverter(this);
case "Power Converter":
return new PowerConverter(this);
case "Frequency Converter":
return new FrequencyConverter(this);
case "Torque Converter":
return new TorqueConverter(this);
case "Fuel Efficiency Converter":
return new FuelEfficiencyConverter(this);
case "Digital Storage Converter":
return new DigitalStorageConverter(this);
}
break;
case "Finance":
switch (subcategory) {
case "Absence Percentage Calculator":
return new AbsencePercentageCalculator(this);
case "Accumulated Depreciation Calculator":
return new AccumulatedDepreciationCalculator(this);
case "Additional Funds Needed Calculator":
return new AdditionalFundsNeededCalculator(this);
case "Attrition Rate Calculator":
return new AttritionRateCalculator(this);
case "Average Collection Period Calculator":
return new AverageCollectionPeriodCalculator(this);
case "Average Fixed Cost Calculator":
return new AverageFixedCostCalculator(this);
case "Bounce Rate Calculator":
return new BounceRateCalculator(this);
case "Break-even Calculator":
return new BreakevenCalculator(this);
case "Interest Calculator":
return new InterestCalculator(this);
case "12-Hour Shift Pay Calculator":
return new HourShiftPayCalculator(this);
case "AGI Calculator":
return new AGICalculator(this);
case "Alabama Tax Calculator":
return new AlabamaTaxCalculator(this);
case "AMT Calculator":
return new AMTCalculator(this);
case "Mortgage Payoff Calculator":
return new MortgagePayoffCalculator(this);
case "Mortgage Penalty Calculator":
return new MortgagePenaltyCalculator(this);
case "Mortgage Points Calculator":
return new MortgagePointsCalculator(this);
case "Mortgage Rate Calculator":
return new MortgageRateCalculator(this);
case "Home Loan Calculator":
return new HomeLoanCalculator(this);
case "Land Loan Calculator":
return new LandLoanCalculator(this);
case "Lease Calculator":
return new LeaseCalculator(this);
case "Lease Mileage Calculator":
return new LeaseMileageCalculator(this);
case "Loan Calculator":
return new LoanCalculator(this);
case "Compound Interest Calculator":
return new CompoundInterestCalculator(this);
case "Loan Payment Calculator":
return new LoanPaymentCalculator(this);
case "Rule of 72 Calculator":
return new Ruleof72Calculator(this);
case "Debt-to-Income Ratio Calculator":
return new DebttoIncomeRatioCalculator(this);
case "Retirement Savings Calculator":
return new RetirementSavingsCalculator(this);
case "Capital Gains Calculator":
return new CapitalGainsCalculator(this);
case "Future Value of Investment Calculator":
return new FutureValueofInvestmentCalculator(this);
case "Loan EMI Calculator":
return new LoanEMICalculator(this);
case "Savings Goal Calculator":
return new SavingsGoalCalculator(this);
case "ROI Calculator":
return new ROICalculator(this);
case "Payback Period Calculator":
return new PaybackPeriodCalculator(this);
case "Dividend Yield Calculator":
return new DividendYieldCalculator(this);
case "Debt Payoff Calculator":
return new DebtPayoffCalculator(this);
case "Savings Interest Calculator":
return new SavingsInterestCalculator(this);
case "Operating Margin Calculator":
return new OperatingMarginCalculator(this);
case "Markup Calculator":
return new MarkupCalculator(this);
case "Revenue Per Employee Calculator":
return new RevenuePerEmployeeCalculator(this);
case "Compound Annual Growth Rate (CAGR) Calculator":
return new CAGRCalculator(this);
}
break;
case "Maths":
switch (subcategory) {
    case "Volume of Cylinder Calculator":
return new VolumeofCylinderCalculator(this);
case "Average Percentage Calculator":
return new AveragePercentageCalculator(this);
case "Fraction to Percent Calculator":
return new FractionToPercentCalculator(this);
case "Decimal to Percent Converter":
return new DecimalToPercentConverter(this);
case "Absolute Value Equation Calculator":
return new AbsoluteValueEquationCalculator(this);
case "Absolute Value Inequalities Calculator":
return new AbsoluteValueInequalitiesCalculator(this);
case "Adding and Subtracting Polynomials Calculator":
return new AddingSubtractingPolynomialsCalculator(this);
case "Absolute Change Calculator":
return new AbsoluteChangeCalculator(this);
case "Absolute Value Calculator":
return new AbsoluteValueCalculator(this);
case "Adding and Subtracting Fractions Calculator":
return new AddingSubtractingFractionsCalculator(this);
case "Mean Calculator":
return new MeanCalculator(this);
case "Average Rate of Change Calculator":
return new AverageRateOfChangeCalculator(this);
case "Bilinear Interpolation Calculator":
return new BilinearInterpolationCalculator(this);
case "Catenary Curve Calculator":
return new CatenaryCurveCalculator(this);
case "Coordinate Grid Calculator":
return new CoordinateGridCalculator(this);
case "Distance Calculator":
return new DistanceCalculator(this);
case "Triangulation Calculator":
return new TriangulationCalculator(this);
case "Unit Vector Calculator":
return new UnitVectorCalculator(this);
case "Vector Calculator":
return new VectorCalculator(this);
case "Adding Fractions Calculator":
return new AddingFractionsCalculator(this);
case "Decimal to Fraction Calculator":
return new DecimalToFractionCalculator(this);
case "Dividing Fractions Calculator":
return new DividingFractionsCalculator(this);
case "Equivalent Fractions Calculator":
return new EquivalentFractionsCalculator(this);
case "Fraction Exponent Calculator":
return new FractionExponentCalculator(this);
case "Fraction To Decimal Converter":
return new FractionToDecimalConverter(this);
case "Golden Ratio Calculator":
return new GoldenRatioCalculator(this);
case "Adjoint Matrix Calculator":
return new AdjointMatrixCalculator(this);
case "Cramer's Rule Calculator":
return new CramersRuleCalculator(this);
case "Matrix Rank Calculator":
return new MatrixRankCalculator(this);
case "Quadratic Equation Solver":
return new QuadraticEquationSolver(this);
case "Factorial Calculator":
return new FactorialCalculator(this);
case "Perimeter Calculator":
return new PerimeterCalculator(this);
case "Area of Circle Calculator":
return new AreaofCircleCalculator(this);
case "Surface Area of Sphere Calculator":
return new SurfaceAreaofSphereCalculator(this);
case "Permutation Calculator":
return new PermutationCalculator(this);
case "Combination Calculator":
return new CombinationCalculator(this);
case "Pythagorean Theorem Calculator":
return new PythagoreanTheoremCalculator(this);
case "Exponential Growth Calculator":
return new ExponentialGrowthCalculator(this);
case "Logarithm Calculator":
return new LogarithmCalculator(this);
case "Root Mean Square (RMS) Calculator":
return new RMSCalculator(this);
}
break;
case "Physics":
switch (subcategory) {
case "Force Calculator":
return new ForceCalculator(this);
case "Displacement Calculator":
return new DisplacementCalculator(this);
case "Friction Calculator":
return new FrictionCalculator(this);
case "Ground Speed Calculator":
return new GroundSpeedCalculator(this);
case "Horizontal Projectile Motion Calculator":
return new HorizontalProjectileMotionCalculator(this);
case "Trajectory Calculator":
return new TrajectoryCalculator(this);
case "Velocity Calculator":
return new VelocityCalculator(this);
case "Acceleration Calculator":
return new AccelerationCalculator(this);
case "Angle of Banking Calculator":
return new AngleOfBankingCalculator(this);
case "Car Crash Calculator":
return new CarCrashCalculator(this);
case "Gravitational Force Calculator":
return new GravitationalForceCalculator(this);
case "Hooke's Law Calculator":
return new HookesLawCalculator(this);
case "Newton's Second Law Calculator":
return new NewtonsSecondLawCalculator(this);
case "Normal Force Calculator":
return new NormalForceCalculator(this);
case "Net Force Calculator":
return new NetForceCalculator(this);
case "Stopping Distance Calculator":
return new StoppingDistanceCalculator(this);
case "Tension Calculator":
return new TensionCalculator(this);
case "Pressure Calculator":
return new PressureCalculator(this);
case "Reduced Mass Calculator":
return new ReducedMassCalculator(this);
case "Impact Energy Calculator":
return new ImpactEnergyCalculator(this);
case "Kinetic Energy Calculator":
return new KineticEnergyCalculator(this);
case "Potential Energy Calculator":
return new PotentialEnergyCalculator(this);
case "Power-to-Weight Ratio Calculator":
return new PowerToWeightRatioCalculator(this);
case "Recoil Energy Calculator":
return new RecoilEnergyCalculator(this);
case "Signal-to-Noise Ratio Calculator":
return new SignalToNoiseRatioCalculator(this);
case "Speed of Light Calculator":
return new SpeedOfLightCalculator(this);
case "Watt Converter":
return new WattConverter(this);
case "Work Calculator":
return new WorkCalculator(this);
case "E = mc² Calculator":
return new Emc2Calculator(this);
case "Drift Velocity Calculator":
return new DriftVelocityCalculator(this);
case "Electrical Power Calculator":
return new ElectricalPowerCalculator(this);
case "Electric Field Calculator":
return new ElectricFieldCalculator(this);
case "Circular Motion Calculator":
return new CircularMotionCalculator(this);
case "Wave Speed Calculator":
return new WaveSpeedCalculator(this);
case "Buoyancy Force Calculator":
return new BuoyancyForceCalculator(this);
case "Capacitance Calculator":
return new CapacitanceCalculator(this);
case "Magnetic Force Calculator":
return new MagneticForceCalculator(this);
case "Induced EMF Calculator":
return new InducedEMFCalculator(this);
case "Thermal Expansion Calculator":
return new ThermalExpansionCalculator(this);
case "Doppler Effect Calculator":
return new DopplerEffectCalculator(this);
case "Lens Formula Calculator":
return new LensFormulaCalculator(this);
case "Thermodynamic Efficiency Calculator":
return new ThermodynamicEfficiencyCalculator(this);
}
break;
case "Stats":
switch (subcategory) {
case "Mean Calculator":
return new MeanCalculator(this);
case "Accuracy Calculator":
return new AccuracyCalculator(this);
case "Coin Flipper":
return new CoinFlipper(this);
case "Coin Flip Probability Calculator":
return new CoinFlipProbabilityCalculator(this);
case "Coin Toss Streak Calculator":
return new CoinTossStreakCalculator(this);
case "Combination Calculator":
return new CombinationCalculator(this);
case "Conditional Probability Calculator":
return new ConditionalProbabilityCalculator(this);
case "Confusion Matrix Calculator":
return new ConfusionMatrixCalculator(this);
case "Dice Average Calculator":
return new DiceAverageCalculator(this);
case "Dice Probability Calculator":
return new DiceProbabilityCalculator(this);
case "Dice Roller Calculator":
return new DiceRollerCalculator(this);
case "Lottery Calculator":
return new LotteryCalculator(this);
case "Monty Hall Problem Calculator":
return new MontyHallProblemCalculator(this);
case "Odds Calculator":
return new OddsCalculator(this);
case "Number Summary Calculator":
return new NumberSummaryCalculator(this);
case "Average Rating Calculator":
return new AverageRatingCalculator(this);
case "Coefficient of Variation Calculator":
return new CoefficientofVariationCalculator(this);
case "Median Calculator":
return new MedianCalculator(this);
case "Median Absolute Deviation Calculator":
return new MedianAbsoluteDeviationCalculator(this);
case "Midrange Calculator":
return new MidrangeCalculator(this);
case "Minimum and Maximum Calculator":
return new MinimumandMaximumCalculator(this);
case "Mode Calculator":
return new ModeCalculator(this);
case "Standard Deviation Calculator":
return new StandardDeviationCalculator(this);
case "Correlation Coefficient Calculator":
return new CorrelationCoefficientCalculator(this);
case "Z-Score Calculator":
return new ZScoreCalculator(this);
case "Confidence Interval Calculator":
return new ConfidenceIntervalCalculator(this);
case "Chi-Square Calculator":
return new ChiSquareCalculator(this);
case "Binomial Probability Calculator":
return new BinomialProbabilityCalculator(this);//28
case "Variance Calculator":
return new VarianceCalculator(this);
case "Regression Line Slope Calculator":
return new RegressionLineSlopeCalculator(this);
case "Poisson Distribution Calculator":
return new PoissonDistributionCalculator(this);
case "Harmonic Mean Calculator":
return new HarmonicMeanCalculator(this);
case "T-Score Calculator":
return new TScoreCalculator(this);
case "Quartile Calculator":
return new QuartileCalculator(this);
case "Skewness Calculator":
return new SkewnessCalculator(this);
case "Kurtosis Calculator":
return new KurtosisCalculator(this);
case "Covariance Calculator":
return new CovarianceCalculator(this);
case "Exponential Smoothing Calculator":
return new ExponentialSmoothingCalculator(this);
}
break;
case "Health":
switch (subcategory) {
case "BMI Calculator":
return new BMICalculator(this);
case "ABSI Calculator":
return new ABSICalculator(this);
case "Adjusted Body Weight Calculator":
return new AdjustedBodyWeightCalculator(this);
case "BAI Calculator":
return new BAICalculator(this);
case "Body Frame Size Calculator":
return new BodyFrameSizeCalculator(this);
case "Body Shape Calculator":
return new BodyShapeCalculator(this);
case "BSA Calculator":
return new BSACalculator(this);
case "Added Sugar Intake Calculator":
return new AddedSugarIntakeCalculator(this);
case "Calorie Deficit Calculator":
return new CalorieDeficitCalculator(this);
case "Carb Calculator":
return new CarbCalculator(this);
case "Cholesterol Ratio Calculator":
return new CholesterolRatioCalculator(this);
case "Karvonen Formula Calculator":
return new KarvonenFormulaCalculator(this);
case "Ponderal Index Calculator":
return new PonderalIndexCalculator(this);
case "Waist to Hip Ratio Calculator":
return new WaistToHipRatioCalculator(this);
case "Waist to Height Ratio Calculator":
return new WaistToHeightRatioCalculator(this);
case "Daily Water Intake Calculator":
return new DailyWaterIntakeCalculator(this);
case "Caffeine Intake Calculator":
return new CaffeineIntakeCalculator(this);
case "Sleep Duration Calculator":
return new SleepDurationCalculator(this);
case "Heart Rate Zone Calculator":
return new HeartRateZoneCalculator(this);
case "Body Temperature Converter":
return new BodyTemperatureConverter(this);
case "Calorie Burn Calculator":
return new CalorieBurnCalculator(this);
case "Breath Rate Calculator":
return new BreathRateCalculator(this);
case "Nicotine Intake Calculator":
return new NicotineIntakeCalculator(this);
case "Screen Time Calculator":
return new ScreenTimeCalculator(this);
case "Basal Metabolic Rate (BMR) Calculator":
return new BMRCalculator(this);
case "Target Heart Rate Calculator":
return new TargetHeartRateCalculator(this);
case "Calorie Intake Calculator":
return new CalorieIntakeCalculator(this);
case "Ideal Weight Calculator":
return new IdealWeightCalculator(this);
case "Lean Body Mass (LBM) Calculator":
return new LBMCalculator(this);
case "Body Water Percentage Calculator":
return new BodyWaterPercentageCalculator(this);
case "Fat Intake Calculator":
return new FatIntakeCalculator(this);
case "Macro Nutrient Calculator":
return new MacroNutrientCalculator(this);
case "Resting Metabolic Rate (RMR) Calculator":
return new RMRCalculator(this);
case "Healthy Body Fat Range Calculator":
return new HealthyBodyFatRangeCalculator(this);
case "Smoking Risk Calculator":
return new SmokingRiskCalculator(this);
}
break;
case "Sports":
switch (subcategory) {
case "Batting Average Calculator":
return new BattingAverageCalculator(this);
case "Dunk Calculator":
return new DunkCalculator(this);
case "Fielding Percentage Calculator":
return new FieldingPercentageCalculator(this);
case "Magic Number Calculator":
return new MagicNumberCalculator(this);
case "On Base Percentage Calculator":
return new OnBasePercentageCalculator(this);
case "Burpee Calorie Calculator":
return new BurpeeCalorieCalculator(this);
case "Calories Burned Calculator":
return new CaloriesBurnedCalculator(this);
case "Calories Burned by Heart Rate Calculator":
return new CaloriesBurnedByHeartRateCalculator(this);
case "Elliptical Calorie Calculator":
return new EllipticalCalorieCalculator(this);
case "Fat Burning Zone Calculator":
return new FatBurningZoneCalculator(this);
case "Hiking Calculator":
return new HikingCalculator(this);
case "Jump Rope Calorie Calculator":
return new JumpRopeCalorieCalculator(this);
case "Running Calorie Calculator":
return new RunningCalorieCalculator(this);
case "Sauna Calories Burned Calculator":
return new SaunaCaloriesBurnedCalculator(this);
case "Snow Shoveling Calories Burned Calculator":
return new SnowShovelingCaloriesBurnedCalculator(this);
case "Stairs Calorie Calculator":
return new StairsCalorieCalculator(this);
case "Batting Strike Rate Calculator":
return new BattingStrikeRateCalculator(this);
case "Bowling Average Calculator":
return new BowlingAverageCalculator(this);
case "Age Grade Calculator":
return new AgeGradeCalculator(this);
case "Bike Cadence and Speed Calculator":
return new BikeCadenceAndSpeedCalculator(this);
case "Bike Gear Calculator":
return new BikeGearCalculator(this);
case "Bike Pace Calculator":
return new BikePaceCalculator(this);
case "Bench Press Calculator":
return new BenchPressCalculator(this);
case "Bench Press Pyramid Calculator":
return new BenchPressPyramidCalculator(this);
case "One-Rep Max Calculator":
return new OneRepMaxCalculator(this);
case "Pace Calculator":
return new PaceCalculator(this);
case "Vo2 Max Calculator":
return new Vo2MaxCalculator(this);
case "Golf Handicap Calculator":
return new GolfHandicapCalculator(this);
case "Protein Intake Calculator for Athletes":
return new ProteinIntakeCalculator(this);
case "Cycling Power Calculator":
return new CyclingPowerCalculator(this);
case "Swimming Calorie Calculator":
return new SwimmingCalorieCalculator(this);
case "Rowing Calorie Calculator":
return new RowingCalorieCalculator(this);
case "Soccer Ball Kick Calculator":
return new SoccerBallKickCalculator(this);
case "Sprint Speed Calculator":
return new SprintSpeedCalculator(this);
case "Swimming Pace Calculator":
return new SwimmingPaceCalculator(this);
case "Tennis Serve Speed Calculator":
return new TennisServeSpeedCalculator(this);
case "Treadmill Calorie Calculator":
return new TreadmillCalorieCalculator(this);
case "Volleyball Spike Speed Calculator":
return new VolleyballSpikeSpeedCalculator(this);
case "Walking Calorie Calculator":
return new WalkingCalorieCalculator(this);
}
break;
default:
return new JPanel();
}
return new JPanel();
}

public void switchToSubcategoryPanel() {
setContentPane(subcategoryPanel);
revalidate();
repaint();
}

public static void main(String[] args) {
SwingUtilities.invokeLater(() -> {
OmniCalculator calculator = new OmniCalculator();
calculator.setVisible(true);
});
}
}
