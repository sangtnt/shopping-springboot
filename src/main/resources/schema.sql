CREATE TABLE `category` (
  `cat_id` bigint(20) NOT NULL,
  `cat_image` varchar(255) DEFAULT NULL,
  `cat_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cat_id`, `cat_image`, `cat_name`) VALUES
(31, '/resources/static/img/category/2019_03_02_66706_1551461528._large.jpg', 'Book'),
(29, '/resources/static/img/category/unnamed.jpg', 'Smart Phone'),
(28, '/resources/static/img/category/imageService.jpg', 'Television'),
(25, '/resources/static/img/category/X5TyA8uvkGXoNyjFzxcowS-1200-80.jpg', 'Laptop');

-- --------------------------------------------------------

--
-- Table structure for table `cus_order`
--

CREATE TABLE `cus_order` (
  `cusorder_id` bigint(20) NOT NULL,
  `order_additionalfees` decimal(10,0) DEFAULT 0,
  `order_address` varchar(255) DEFAULT NULL,
  `order_date` bigint(20) DEFAULT NULL,
  `order_discount` decimal(10,0) DEFAULT 0,
  `order_cus_fullname` varchar(255) DEFAULT NULL,
  `order_grandtotal` double DEFAULT NULL,
  `order_cus_phone` varchar(255) DEFAULT NULL,
  `order_shipping` decimal(10,0) DEFAULT 0,
  `order_status` int(11) DEFAULT NULL,
  `order_subtotal` double DEFAULT NULL,
  `user_username` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cus_order`
--

INSERT INTO `cus_order` (`cusorder_id`, `order_additionalfees`, `order_address`, `order_date`, `order_discount`, `order_cus_fullname`, `order_grandtotal`, `order_cus_phone`, `order_shipping`, `order_status`, `order_subtotal`, `user_username`) VALUES
(1, '0', 'HCM 9 232/3, Long Thuan, Long', 1595497049703, '0', 'Tan Sang', 196830, '0583217159', '30', 0, 196800, '0583217159');

-- --------------------------------------------------------

--
-- Table structure for table `image_product`
--

CREATE TABLE `image_product` (
  `image_id` bigint(20) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `pro_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `image_product`
--

INSERT INTO `image_product` (`image_id`, `image`, `pro_id`) VALUES
(20, '/resources/static/img/product/617WKto5bpL._AC_SL1000_.jpg', 1),
(19, '/resources/static/img/product/51zqSEQ0hgL._AC_SL1000_.jpg', 1),
(18, '/resources/static/img/product/51sVkeGcY2L._AC_SL1000_.jpg', 1),
(17, '/resources/static/img/product/51Fhv2unbdL._AC_SL1000_.jpg', 1),
(16, '/resources/static/img/product/51cB5PhQesL._AC_SL1000_.jpg', 1),
(15, '/resources/static/img/product/51B4zvRbRBL._AC_SL1000_.jpg', 1),
(14, '/resources/static/img/product/31OP2iHMLOL._AC_.jpg', 1),
(28, '/resources/static/img/product/51krCjc1V9L._AC_SL1500_.jpg', 3),
(29, '/resources/static/img/product/51XYqKqmeXL._AC_SL1024_.jpg', 3),
(30, '/resources/static/img/product/61mvi+Jxo4L._AC_SL1500_.jpg', 3),
(31, '/resources/static/img/product/71AOuCp1kCL._AC_SL1500_.jpg', 3),
(32, '/resources/static/img/product/71y+lIHVdAL._AC_SL1500_.jpg', 4),
(33, '/resources/static/img/product/71ZSkbNoH0L._AC_SL1500_.jpg', 4),
(34, '/resources/static/img/product/NLT177L._AC_SL1500_.jpg', 4),
(35, '/resources/static/img/product/X9dGhCkL._AC_SL1500_.jpg', 4),
(36, '/resources/static/img/product/91MocDmeG8L._AC_SL1500_.jpg', 4),
(37, '/resources/static/img/product/91U2rQzjz6L._AC_SL1500_.jpg', 4),
(38, '/resources/static/img/product/61dJmFsIodL._AC_SL1500_.jpg', 5),
(39, '/resources/static/img/product/71DJ+ltsayL._AC_SL1500_.jpg', 5),
(40, '/resources/static/img/product/71gI0aAe7eL._AC_SL1500_.jpg', 5),
(41, '/resources/static/img/product/71Jzr6mjKZL._AC_SL1500_.jpg', 5),
(42, '/resources/static/img/product/71k3fJh5EwL._AC_SL1500_.jpg', 5),
(43, '/resources/static/img/product/91Loxy58WtL._AC_SL1500_.jpg', 5),
(55, '/resources/static/img/product/710spG1y9HL._AC_SL1500_.jpg', 8),
(50, '/resources/static/img/product/51GcMlT1nmL._AC_SL1000_.jpg', 6),
(49, '/resources/static/img/product/41ZoJhMEP7L._AC_.jpg', 6),
(54, '/resources/static/img/product/71YZlXXFktL._AC_SL1500_.jpg', 8),
(56, '/resources/static/img/product/1MLcL._AC_SL1500_.jpg', 8),
(57, '/resources/static/img/product/71AVRexOUTL._AC_SL1000_.jpg', 9),
(58, '/resources/static/img/product/71RiQZ0J2SL._AC_SL1000_.jpg', 9),
(59, '/resources/static/img/product/917BDURjqqL._AC_SL1500_.jpg', 9),
(60, '/resources/static/img/product/81R0kFg8MML._AC_SL1500_.jpg', 9),
(62, '/resources/static/img/product/61sdhocjgRL._AC_SL1200_.jpg', 11),
(63, '/resources/static/img/product/71guRy2Wo4L._AC_SL1200_.jpg', 11),
(64, '/resources/static/img/product/71VC9cPNy6L._AC_SL1080_.jpg', 11),
(65, '/resources/static/img/product/71zTDTsFp3L._AC_SL1500_.jpg', 11),
(66, '/resources/static/img/product/91eCntfGgcL._AC_SL1500_.jpg', 11),
(67, '/resources/static/img/product/4135xkfaNGL._AC_SL1200_.jpg', 11),
(68, '/resources/static/img/product/61emQEDMdSL._AC_SL1000_.jpg', 12),
(69, '/resources/static/img/product/61pzhWiGSbL._AC_SL1000_.jpg', 12),
(70, '/resources/static/img/product/61W9nghpo4L._AC_SL1000_.jpg', 12),
(71, '/resources/static/img/product/71in93uLbVL._AC_SL1000_.jpg', 12),
(72, '/resources/static/img/product/71tg3KFTSiL._AC_SL1000_.jpg', 12),
(73, '/resources/static/img/product/vdL._AC_SL1500_.jpg', 12),
(74, '/resources/static/img/product/91WMYjSFtzL._AC_SL1500_.jpg', 12),
(75, '/resources/static/img/product/HD_200116730_01.jpg', 13),
(76, '/resources/static/img/product/HD_200116594_01.jpg', 14),
(77, '/resources/static/img/product/HD_200116550_01.jpg', 15),
(78, '/resources/static/img/product/HD_200116397_01.jpg', 16),
(85, '/resources/static/img/product/51if47n2aPL._AC_SL1000_.jpg', 2),
(86, '/resources/static/img/product/51lqPrvD1HL._AC_SL1000_.jpg', 2),
(87, '/resources/static/img/product/51ymN8d4pxL._AC_SL1000_.jpg', 2),
(88, '/resources/static/img/product/61X5FS9sxgL._AC_SL1000_.jpg', 2),
(89, '/resources/static/img/product/516blyGRtgL._AC_SL1000_.jpg', 2),
(90, '/resources/static/img/product/518zTcn9IyL._AC_SL1000_.jpg', 2),
(91, '/resources/static/img/product/61UyVOfALkL._AC_SL1500_.jpg', 17),
(92, '/resources/static/img/product/71cnzwCTohL._AC_SL1080_.jpg', 17),
(93, '/resources/static/img/product/71hGmuVUynL._AC_SL1500_.jpg', 17),
(94, '/resources/static/img/product/71oUtzqoodL._AC_SL1080_.jpg', 17),
(95, '/resources/static/img/product/71wkQg09S6L._AC_SL1080_.jpg', 17),
(96, '/resources/static/img/product/71wNRkfTmuL._AC_SL1500_.jpg', 17),
(97, '/resources/static/img/product/81ZwjEaw5QL._AC_SL1500_.jpg', 17),
(98, '/resources/static/img/product/51GX14nuGWL._AC_SL1000_.jpg', 18),
(99, '/resources/static/img/product/313MUW3jLOL._AC_.jpg', 18),
(108, '/resources/static/img/product/81agJtWPqrL._AC_SL1500_.jpg', 19),
(107, '/resources/static/img/product/alHEL._AC_SL1500_.jpg', 19),
(106, '/resources/static/img/product/71oOh3jjM9L._AC_SL1500_.jpg', 19),
(105, '/resources/static/img/product/71Nw3dlK86L._AC_SL1500_.jpg', 19);

-- --------------------------------------------------------

--
-- Table structure for table `order_detail`
--

CREATE TABLE `order_detail` (
  `order_detail_id` bigint(20) NOT NULL,
  `order_detail_quantity` bigint(20) DEFAULT NULL,
  `order_detail_subtotal` double DEFAULT NULL,
  `cusorder_id` bigint(20) DEFAULT NULL,
  `pro_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `order_detail`
--

INSERT INTO `order_detail` (`order_detail_id`, `order_detail_quantity`, `order_detail_subtotal`, `cusorder_id`, `pro_id`) VALUES
(1, 200, 196800, 1, 9);

-- --------------------------------------------------------

--
-- Table structure for table `permission`
--

CREATE TABLE `permission` (
  `persmission_id` bigint(20) NOT NULL,
  `persmission_name` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `permission`
--

INSERT INTO `permission` (`persmission_id`, `persmission_name`) VALUES
(4, 'ORDER MANAGER'),
(3, 'PRODUCT MANAGER'),
(2, 'USER'),
(1, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `pro_id` bigint(20) NOT NULL,
  `pro_brand` varchar(255) DEFAULT NULL,
  `pro_date` bigint(20) DEFAULT NULL,
  `pro_description` longtext DEFAULT NULL,
  `pro_discount` decimal(10,0) DEFAULT 0,
  `pro_name` varchar(1000) DEFAULT NULL,
  `pro_origin` varchar(255) DEFAULT NULL,
  `pro_price` double DEFAULT NULL,
  `pro_quantity` bigint(20) DEFAULT NULL,
  `pro_rating` bigint(20) DEFAULT NULL,
  `pro_research` decimal(10,0) DEFAULT 0,
  `pro_shipping` decimal(10,0) DEFAULT 0,
  `pro_sold` decimal(10,0) DEFAULT 0,
  `cat_id` bigint(20) NOT NULL,
  `user_username` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pro_id`, `pro_brand`, `pro_date`, `pro_description`, `pro_discount`, `pro_name`, `pro_origin`, `pro_price`, `pro_quantity`, `pro_rating`, `pro_research`, `pro_shipping`, `pro_sold`, `cat_id`, `user_username`) VALUES
(1, 'Dell', 1595492314108, 'Intel 10th Gen Dual Core i3-1005G1 Processor (1.2GHz, up to 3.4GHz, 4MB cache, 2 cores) 8GB DDR4 SDRAM, 128GB Solid State Drive, 1TB HDD, Intel UHD Graphics 15.6 inch Touchscreen HD (1366 x 768) Display Intel 802.11 ac Wi-Fi + Bluetooth 4.1, Webcam, HDMI, RJ-45 2 × USB-Type-A 3.0, 1 × USB Type-A 2.0, Windows 10 Home 64 bit', '0', '2020 Dell Inspiron 3000 15.6-inch HD Touchscreen Laptop PC, Intel 10th Gen Dual Core i3-1005G1 Processor, 8GB DDR4, 128GB SSD, 1TB HDD, Bluetooth, Windows 10, Black', 'USA', 489, 1000, 0, '0', '0', '0', 25, 'proManager'),
(2, 'Dell', 1595649851596, 'Intel i3-8145U, dual-core, four-way; 8GB ddr4 system memory; 128GB Solid State Drive (PCI-e); 15. 6', '0', 'New ! Dell Inspiron i3583 15.6', 'VIETNAM', 478.9, 100, 0, '0', '0', '0', 25, 'proManager'),
(3, 'Dell', 1595492676873, 'This product has been professionally inspected and tested by Amazon-qualified suppliers. The product may have minimal scratches or dents, and a battery with at least 80% capacity. Box may be generic and accessories may not be original, but will be compatible and fully functional. This product is eligible for a replacement or refund within 90 days of receipt if you are not satisfied.', '0', 'Fast Dell Latitude E5470 HD Business Laptop Notebook PC (Intel Core i5-6300U, 8GB Ram, 256GB Solid State SSD, HDMI, Camera, WiFi) Win 10 Pro SC Card Reader (Renewed)', 'JAPAN', 599.77, 200, 0, '0', '0', '0', 25, 'proManager'),
(4, 'USA', 1595492810065, 'Ninth-generation 6-Core Intel Core i7 Processor Stunning 16-inch Retina Display with True Tone technology Touch Bar and Touch ID Amd Radeon Pro 5300M Graphics with GDDR6 memory Ultrafast SSD Intel UHD Graphics 630 Six-speaker system with force-cancelling woofers', '0', 'New Apple MacBook Pro (16-Inch, 16GB RAM, 512GB Storage, 2.6GHz Intel Core i7) - Silver', 'Apple', 2099.99, 200, 0, '0', '0', '0', 25, 'proManager'),
(5, 'Apple', 1595493023178, 'Stunning 13.3-inch Retina display with True Tone technology Backlit Magic Keyboard and Touch ID Tenth-generation Intel Core i3 processor Intel Iris Plus Graphics Fast SSD storage 8GB of memory Stereo speakers with wider stereo sound', '0', 'Apple MacBook Air (13-inch, 8GB RAM, 256GB SSD Storage) - Space Gray (Latest Model)', 'USA', 949, 123, 0, '0', '0', '0', 25, 'proManager'),
(6, 'INSIGNIA', 1595493354301, 'Insignia HD Smart TV – Fire TV Edition delivers 720p picture quality with deep blacks and rich colors. With the Fire TV experience built-in, enjoy tens of thousands of channels, apps, and Alexa skills, including Disney+, Netflix, YouTube, Prime Video, Hulu, HBO, SHOWTIME, STARZ, and more Fire TV Edition seamlessly integrates live over-the-air TV and streaming channels on a unified home screen (HD antenna required). Easily control your TV with the included Voice Remote with Alexa—plus, launch apps, search for titles, play music, switch inputs, control smart home devices, and more, using just your voice. Dimensions (W x H x D): TV without stand: 28.9” x 17.3” x 3”, TV with stand: 28.9” x 19” x 8.2”. Multiple device input/output options: 3 HDMI including 1 with ARC, USB, composite input, antenna/cable input, digital output (optical), audio output, Ethernet.', '0', 'Insignia NS-32DF310NA19 32-inch Smart HD TV - Fire TV Edition', 'VIETNAM', 139.99, 100, 0, '0', '0', '0', 28, 'proManager'),
(8, 'TCL', 1595494123666, 'Dimensions (W x H x D): TV without stand: 35.6 X 20.5 X 2.9 inches, TV with stand: 35.6 X 22.7 X 7.2 inches Smart functionality delivers all your favorite content with over 500,000 movies and TV episodes, accessible through the simple and intuitive Roku TV 1080p HD resolution for a lifelike picture Direct lit LED produces great picture quality Inputs: 3 HDMI 2.0 with HDCP 2.2 (one with HDMI ARC), 1 USB (media player), RF, Composite, Headphone Jack, Optical Audio Out Compatible with Alexa and Google Assistant', '0', 'TCL 40S325 40 Inch 1080p Smart LED Roku TV', 'USA', 268.23, 100, 0, '0', '0', '0', 28, 'proManager'),
(9, 'SAMSUNG', 1595496885128, 'CRYSTAL PROCESSOR 4K: This ultra-fast processor transforms everything you watch into stunning 4K. MULTI VOICE: Smart TV with Alexa and Bixby. SMART TV POWERED BY TIZEN : Go beyond Smart TV with next-gen apps, super easy control, and a host of enhancements that elevate the TV watching experience. HDR: Unveils shades of color you can\'t find on HDTV. CRYSTAL DISPLAY: Experience crystal clear colors that are fine-tuned to deliver a naturally crisp and vivid picture. ALEXA BUILT-IN: Ask more from your TV. Just ask Alexa to open apps, change the channel, search for movies and shows, play music, control your smart home devices and more. To talk to Alexa, press and hold the mic button on your remote.', '18', 'SAMSUNG 55-Inch Class Crystal UHD TU-8000 Series - 4K UHD HDR Smart TV with Alexa Built-in (UN55TU8000FXZA, 2020 Model)', 'VIETNAM', 1200, 0, 0, '0', '0', '200', 28, 'proManager'),
(11, 'Sony', 1595645688476, '4K HDR PROCESSOR X1: See premium 4K pictures, rich with real-world detail and texture. Upscale everything you watch to near-4K with 4K X-Reality PRO. TRILUMINOS Display: See exactly what the creator intended with advanced color and gradation GAME MODE: Take your PlayStation experience to the next level with a Sony 4K gaming TV featuring dedicated Game Mode for a smoother, more responsive gaming experience. SMART ANDROID TV with GOOGLE ASSISTANT: Use your voice to control your TV and smart home devices, easily search for movies and shows, get answers, and manage tasks. WORKS WITH ALEXA: Stream smart camera feeds with your voice. Through an Alexa enabled device, just ask Alexa to play music, launch video apps, turn up the volume, and more. APPLE AIRPLAY 2 and HOMEKIT SUPPORT: Seamlessly integrate your iPhone and Siri devices with your Sony TV for effortless smart home management and content streaming. HDR and DOLBY VISION: Bring scenes to life with striking highlights, deeper darks and vibrant colors. MOTIONFLOW XR: Less blur, even in fast scenes. Content appears with lifelike motion.', '10', 'Sony X800H 49 Inch TV: 4K Ultra HD Smart LED TV with HDR and Alexa Compatibility - 2020 Model', 'USA', 1400, 2000, 0, '0', '0', '0', 28, 'proManager'),
(12, 'Samsung', 1595645912850, 'DIRECT FULL ARRAY 16X* (75\", 65\" & 55\"): Fine control of the lighting zones behind the screen, further improve the richness of the blacks to whites. ULTRA VIEWING ANGLE: Engineered to reduce glare and enhance color, providing a vibrant picture no matter where you sit. QUANTUM HDR 16X: A wider range of brightness and color come together for a strikingly vivid and cinematic picture. OBJECT TRACKING SOUND: Two top and two bottom built-in TV speakers adjust the sound to follow the action. QUANTUM PROCESSOR 4K: This powerful processor uses deep learning AI to transform everything you watch into stunning 4K. ALEXA BUILT-IN: Ask more from your TV. Just ask Alexa to open apps, change the channel, search for movies and shows , play music, control your smart home devices and more. To talk to Alexa, press and hold the mic button on your remote. If you have hands-free enabled just say, \"Alexa\" and ask a question.', '50', 'SAMSUNG 75-inch Class QLED Q90T Series - 4K UHD Direct Full Array 16X Quantum HDR 16X Smart TV with Alexa Built-in (QN75Q90TAFXZA, 2020 Model)', 'VietNam', 2000.98, 1000, 0, '0', '0', '0', 28, 'proManager'),
(13, 'SELF-HELP', 1595647949932, 'The Shielding of Mrs Forbes  Graham Forbes is a disappointment to his mother, who thinks that if he must have a wife, he should have done better. Though her own husband isn\'t all that satisfactory either. Still, this is Alan Bennett, so what is happening in the bedroom (and in lots of other places too) is altogether more startling, perhaps shocking, and ultimately more true to people\'s predilections.  The Greening of Mrs Donaldson  Mrs Donaldson is a conventional middle-class woman beached on the shores of widowhood after a marriage that had been much like many others: happy to begin with, then satisfactory and finally dull. But when she decides to take in two lodgers, her mundane life becomes much more stimulating...', '5', 'SMUT', 'UK', 2.49, 100, 0, '0', '0', '0', 31, 'proManager'),
(14, 'SELF-HELP', 1595648348361, 'The second book in Philippa\'s stunning new trilogy, The Cousins War, brings to life the story of Margaret Beaufort, a shadowy and mysterious character in the first book of the series - The White Queen - but who now takes centre stage in the bitter struggle of The War of the Roses. The Red Queentells the story of the child-bride of Edmund Tudor, who, although widowed in her early teens, uses her determination of character and wily plotting to infiltrate the house of York under the guise of loyal friend and servant, undermine the support for Richard III and ultimately ensure that her only son, Henry Tudor, triumphs as King of England. Through collaboration with the dowager Queen Elizabeth Woodville, Margaret agrees a betrothal between Henry and Elizabeth\'s daughter, thereby uniting the families and resolving the Cousins War once and for all by founding of the Tudor dynasty.', '0', 'THE RED QUEEN', 'USA', 2.49, 100, 0, '0', '0', '0', 31, 'proManager'),
(15, 'SELF-HELP', 1595648468402, 'The second Jackson Brodie novel (after Case Histories): literary crime from the prizewinning, number-one bestselling author of Big Sky and Transcription.\'An absolute joy to read...the pleasure of One Good Turn lies in the ride, in Atkinson\'s wry, unvanquished characters, her swooping, savvy, sarcastic prose and authorial joie de vivre\' GuardianIt is summer, it is the Edinburgh Festival. People queuing for a lunchtime show witness a road-rage incident - a near-homicidal attack which changes the lives of everyone involved. Jackson Brodie, ex-army, ex-police, ex-private detective, is also an innocent bystander - until he becomes a murder suspect. As the body count mounts, each member of the teeming Dickensian cast\'s story contains a kernel of the next, like a set of nesting Russian dolls. They are all looking for love or money or redemption or escape: but what each actually discovers is their own true self.', '17', 'ONE GOOD TURN', 'VietNam', 2.49, 100, 0, '0', '0', '0', 31, 'proManager'),
(16, 'SELF-HELP', 1595648674647, 'Internationally bestselling author Philippa Gregory brings the tumult and intrigue of The Wars of the Roses to vivid life through the women of the House of Lancaster and the House of York, beginning with the story of Elizabeth Woodville, the White Queen. A woman who won the love of a king and ascended to royalty by virtue of her beauty, Elizabeth fought tenaciously for the success of her family -- her daughter who would one day unite the warring dynasties, and her two sons whose eventual fate has confounded historians for centuries: the Princes in the Tower. An active player in the power struggles that surrounded her, she made hard and courageous choices, always trying to protect those whom she loved. Informed by impeccable research and framed by her inimitable storytelling skills, Philippa Gregory gives an unforgettable voice to an extraordinary woman at the heart of a devastating conflict.', '0', 'THE WHITE QUEEN', 'USA', 2.99, 2000, 0, '0', '0', '0', 31, 'proManager'),
(17, 'Nokia', 1595650137599, 'Expand your view with the Nokia 1.3, featuring the latest mobile tech at an affordable price — including an HD+ display with improved brightness, AI powered imaging, a removable battery with a two-day life, and processing power that keeps up with you. Take stunningly beautiful photos even in darker conditions with the 8 MP rear camera\'s low-light imaging enhancement, and find your images faster thanks to automatic organization with the Gallery Go photos app. The 5.71-inch HD+ edge-to-edge screen is optimized for both indoors and the bright outdoors, while the Qualcomm 215 Mobile Platform gives you power when you need it most plus helps you go even further with all-day battery life. Call friends, catch up on the news, and get the latest weather reports by pressing the dedicated Google Assistant button, which makes it easy to ask questions, update calendars, check traffic, and more. Loaded with Android 10 (Go edition) and ready for Android 11 (Go edition), it features a 16 GB internal storage, MicroSD card support up to 400 GB, and WiFi and Bluetooth 4.2 connectivity. It comes with a charger, and Micro USB cable (SIM card not included). Included components: Quick Start Guide', '0', 'Nokia 1.3 Fully Unlocked Smartphone with 5.7\" HD+ Screen, AI-Powered 8 MP Camera and Android 10 Go Edition, Charcoal, 2020 (AT&T/T-Mobile/Cricket/Tracfone/Simple Mobile)', 'USA', 99.99, 1000, 0, '0', '0', '0', 29, 'proManager'),
(18, 'Samsung', 1595650236329, 'International Model - No Warranty in US. Compatible with Most GSM Carriers like T-Mobile, AT&T, MetroPCS, etc. Will NOT work with CDMA Carriers Such as Verizon, Sprint, Boost RAM 3GB , ROM 32GB Internal Memory ; MicroSD (Up to 512GB), Android 9.0 (Pie), Qualcomm SDM450 Snapdragon 450 (14 nm), Octa-core 1.8 GHz Cortex-A53, Adreno 506 Main Rear Camera: 13.0 MP + 8.0 MP + 5.0 MP , F1.8 , F2.2 , F2.2 ; Front Camera: 8.0 MP , F2.0, Non-removable Li-Po 4000 mAh battery 3G HSDPA 850 / 900 / 1700(AWS) / 1900 / 2100, 4G LTE band 1(2100), 2(1900), 3(1800), 5(850), 7(2600), 8(900), 20(800), 28(700), 34(2000), 38(2600), 39(1900), 40(2300), 41(2500) 6.5 inches, 103.7 cm2 (~81.9% screen-to-body ratio) 720 x 1560 pixels (HD+), 19.5:9 ratio (~264 ppi density) IPS LCD capacitive touchscreen, 16M colors', '5', 'Samsung Galaxy A20s A207M/DS, 32GB/3GB RAM Dual SIM 6.5\'\'HD+ Snapdragon 450, Factory Unlocked (International Version) - (Red)', 'UK', 168.99, 100, 0, '0', '0', '0', 29, 'proManager'),
(19, 'Motorola', 1595650493019, 'Pre-installed selection of Amazon apps, including Amazon Shopping, Amazon Music, Audible and Amazon Alexa Amazon exclusive version with Amazon Alexa built-in: Simply say “Alexa” or double press the power button to play music, hear the news or check the weather wherever you are. Just ask - and Alexa will respond instantly 6.2', '13', 'Moto G7 with Alexa Hands-Free – Unlocked – 64 GB – Ceramic Black (US Warranty) – Verizon, AT&T, T–Mobile, Sprint, Boost, Cricket, & Metro', 'USA', 229.99, 1000, 0, '0', '0', '0', 29, 'proManager');

-- --------------------------------------------------------

--
-- Table structure for table `shopping_cart`
--

CREATE TABLE `shopping_cart` (
  `cart_id` bigint(20) NOT NULL,
  `cart_date` bigint(20) DEFAULT NULL,
  `cart_quantity` bigint(20) DEFAULT NULL,
  `cart_total` double DEFAULT NULL,
  `pro_id` bigint(20) NOT NULL,
  `user_username` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_username` varchar(30) NOT NULL,
  `user_address` varchar(255) DEFAULT NULL,
  `user_balance` decimal(10,0) DEFAULT 0,
  `user_date` bigint(20) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_fullname` varchar(255) DEFAULT NULL,
  `user_gender` varchar(255) DEFAULT NULL,
  `user_image` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_status` tinyint(1) DEFAULT 1
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_username`, `user_address`, `user_balance`, `user_date`, `user_email`, `user_fullname`, `user_gender`, `user_image`, `user_password`, `user_phone`, `user_status`) VALUES
('admin', NULL, NULL, 1595404910511, NULL, 'ADMIN', NULL, '/resources/static/img/avatar/admin.jpg', '$2a$10$W8uA8jtgKzfTNjIYKt9ljOie4JJEzlks/.PSneKMk4s6CMjtj5V4O', NULL, 1),
('proManager', NULL, NULL, 1595404910643, NULL, 'PRODUCT MANAGER', NULL, '/resources/static/img/avatar/admin.jpg', '$2a$10$FJdJyzjUrdFC01g/A/PXOOrXd/J/NMKRcul0A0I5C.yMw3FRAYWV6', NULL, 1),
('orderManager', NULL, NULL, 1595404910747, NULL, 'ORDER MANAGER', NULL, '/resources/static/img/avatar/admin.jpg', '$2a$10$fN1f3hhTI5DmzvlCbRLhqOdX2b29hlW5UgkqwYjEJK9ODrBXQdDwi', NULL, 1),
('0583217159', NULL, NULL, 1595404943793, 'sangtntgcs190019@gmail.com', 'Tan Sang', 'male', '/resources/static/img/avatar/male.png', '$2a$10$uKn/HjBVVHbMd4.0HPh6UutdM6SK7nFYr7bZoLi.kwJXSM6LkQa5G', '0583217159', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_like_pro`
--

CREATE TABLE `user_like_pro` (
  `user_username` varchar(30) NOT NULL,
  `pro_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_like_pro`
--

INSERT INTO `user_like_pro` (`user_username`, `pro_id`) VALUES
('0583217159', 5),
('0583217159', 6);

-- --------------------------------------------------------

--
-- Table structure for table `user_permission`
--

CREATE TABLE `user_permission` (
  `user_username` varchar(30) NOT NULL,
  `permission_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_permission`
--

INSERT INTO `user_permission` (`user_username`, `permission_id`) VALUES
('admin', 1),
('0583217159', 2),
('proManager', 3),
('orderManager', 4);

-- --------------------------------------------------------

--
-- Table structure for table `user_rate_pro`
--

CREATE TABLE `user_rate_pro` (
  `user_rate_pro_id` bigint(20) NOT NULL,
  `rating` bigint(20) DEFAULT NULL,
  `pro_id` bigint(20) NOT NULL,
  `user_username` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user_review_pro`
--

CREATE TABLE `user_review_pro` (
  `user_review_pro_id` bigint(20) NOT NULL,
  `user_review_pro_date` bigint(20) DEFAULT NULL,
  `user_review_pro_image` varchar(255) DEFAULT NULL,
  `user_review_pro_review` varchar(255) DEFAULT NULL,
  `pro_id` bigint(20) NOT NULL,
  `user_username` varchar(30) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_review_pro`
--

INSERT INTO `user_review_pro` (`user_review_pro_id`, `user_review_pro_date`, `user_review_pro_image`, `user_review_pro_review`, `pro_id`, `user_username`) VALUES
(1, 1595646237531, '', 'bullshit', 6, '0583217159');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cat_id`);

--
-- Indexes for table `cus_order`
--
ALTER TABLE `cus_order`
  ADD PRIMARY KEY (`cusorder_id`),
  ADD KEY `FK8182xssohgujrd6mxos5wlo3j` (`user_username`);

--
-- Indexes for table `image_product`
--
ALTER TABLE `image_product`
  ADD PRIMARY KEY (`image_id`),
  ADD KEY `FKipm8ycv4kgtulkq1yv7jwwaa1` (`pro_id`);

--
-- Indexes for table `order_detail`
--
ALTER TABLE `order_detail`
  ADD PRIMARY KEY (`order_detail_id`),
  ADD KEY `FK6s8qsxhytmytkfqcmu3m3pdot` (`cusorder_id`),
  ADD KEY `FKt1alidop4w9a5evgouqj02vgd` (`pro_id`);

--
-- Indexes for table `permission`
--
ALTER TABLE `permission`
  ADD PRIMARY KEY (`persmission_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pro_id`),
  ADD KEY `FK5yhiu7ri51c4oigkb28skv0b2` (`cat_id`),
  ADD KEY `FK4lxkhq5mij7cdbho3qj7bsrbx` (`user_username`);

--
-- Indexes for table `shopping_cart`
--
ALTER TABLE `shopping_cart`
  ADD PRIMARY KEY (`cart_id`),
  ADD KEY `FKl9dgttnafyurvj6tuix4dbhks` (`pro_id`),
  ADD KEY `FKe3cmnacrjx2gnl9qg2q1wphnl` (`user_username`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_username`);

--
-- Indexes for table `user_like_pro`
--
ALTER TABLE `user_like_pro`
  ADD PRIMARY KEY (`pro_id`,`user_username`),
  ADD KEY `FKm33wvvra4jf3g47k6n8wg8u71` (`user_username`);

--
-- Indexes for table `user_permission`
--
ALTER TABLE `user_permission`
  ADD PRIMARY KEY (`permission_id`,`user_username`),
  ADD KEY `FKhgy31hlltrdwh84r9kx4ib612` (`user_username`);

--
-- Indexes for table `user_rate_pro`
--
ALTER TABLE `user_rate_pro`
  ADD PRIMARY KEY (`user_rate_pro_id`),
  ADD KEY `FK12c7c3g3ddg4nau3mskl7jkrd` (`pro_id`),
  ADD KEY `FKi4qaapf5lo0kvnkeipv9u7y9w` (`user_username`);

--
-- Indexes for table `user_review_pro`
--
ALTER TABLE `user_review_pro`
  ADD PRIMARY KEY (`user_review_pro_id`),
  ADD KEY `FKieefe5pv7vfwn1450i9qk5l02` (`pro_id`),
  ADD KEY `FK68cbcm2mt1sqee4a3q8edvkv3` (`user_username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `cat_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `cus_order`
--
ALTER TABLE `cus_order`
  MODIFY `cusorder_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `image_product`
--
ALTER TABLE `image_product`
  MODIFY `image_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=109;

--
-- AUTO_INCREMENT for table `order_detail`
--
ALTER TABLE `order_detail`
  MODIFY `order_detail_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `permission`
--
ALTER TABLE `permission`
  MODIFY `persmission_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `pro_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `shopping_cart`
--
ALTER TABLE `shopping_cart`
  MODIFY `cart_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user_rate_pro`
--
ALTER TABLE `user_rate_pro`
  MODIFY `user_rate_pro_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user_review_pro`
--
ALTER TABLE `user_review_pro`
  MODIFY `user_review_pro_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
