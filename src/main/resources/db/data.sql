-- Sample data for the Sport table
INSERT INTO sport (sport_id, sport_name, sport_admin, sport_win_points, sport_draw_points, sport_lose_points) VALUES
  ('1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'Football', 'auth0|653c25b9398960f19a6d8e6a', 3, 1, 0),
  ('ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'Basketball', 'auth0|653c25b9398960f19a6d8e6a', 2, 1, 0),
  ('30b4c0a1-cc03-4d0c-8df4-57057d40d99e', 'Baseball', 'auth0|653c25b9398960f19a6d8e6a', 2, 1, 0),
  ('ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'Rugby', 'auth0|653c25b9398960f19a6d8e6a', 4, 2, 0),
  ('a021dc1e-7c8d-4717-aafc-9885290b15a6', 'Cricket', 'auth0|653c25b9398960f19a6d8e6a', 2, 1, 0),
  ('40a1a183-f098-4cfc-9f44-075c6ad7d72b', 'Hockey', 'auth0|653c25b9398960f19a6d8e6a', 3, 1, 0),
  ('b2074758-9e8d-4b1c-b43c-19093b635903', 'Volleyball', 'auth0|653c25b9398960f19a6d8e6a', 3, 1, 0),
  ('09b6c90e-ec84-4864-93b7-bdd7988bf777', 'Tennis', 'auth0|653c25b9398960f19a6d8e6a', 2, 1, 0),
  ('c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'Handball', 'auth0|653c25b9398960f19a6d8e6a', 2, 1, 0);


-- Sample data for the League table
INSERT INTO league (league_id, league_name, league_schedule, league_sport, league_admin) VALUES
  ('1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'Premier League', null, '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a'),
  ('ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'NBA', null, 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'auth0|653c25b9398960f19a6d8e6a'),
  ('30b4c0a1-cc03-4d0c-8df4-57057d40d99e', 'MLB', null, '30b4c0a1-cc03-4d0c-8df4-57057d40d99e', 'auth0|653c25b9398960f19a6d8e6a'),
  ('ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'Six Nations', null, 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'auth0|653c25b9398960f19a6d8e6a'),
  ('a021dc1e-7c8d-4717-aafc-9885290b15a6', 'IPL', null, 'a021dc1e-7c8d-4717-aafc-9885290b15a6', 'auth0|653c25b9398960f19a6d8e6a'),
  ('40a1a183-f098-4cfc-9f44-075c6ad7d72b', 'NHL', null, '40a1a183-f098-4cfc-9f44-075c6ad7d72b', 'auth0|653c25b9398960f19a6d8e6a'),
  ('b2074758-9e8d-4b1c-b43c-19093b635903', 'Volleyball League', null, 'b2074758-9e8d-4b1c-b43c-19093b635903', 'auth0|653c25b9398960f19a6d8e6a'),
  ('09b6c90e-ec84-4864-93b7-bdd7988bf777', 'Tennis League', null, '09b6c90e-ec84-4864-93b7-bdd7988bf777', 'auth0|653c25b9398960f19a6d8e6a'),
  ('c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'Handball League', null, 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'auth0|653c25b9398960f19a6d8e6a');

-- Sample data for the Team table
INSERT INTO team (team_id, team_name, team_league, team_sport, team_admin, team_position, team_points) VALUES
  ('1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'Manchester United', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', 3, 0),
  ('e4b4df8d-97aa-47f9-9313-d5d8c58c5aa4', 'Liverpool', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', 1, 3),
  ('41b13c22-ef43-4d8a-aab2-fa05e897c285', 'Arsenal', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', 4, 0),
  ('2e4a9c63-7a57-4ebc-a0e0-1a67651a70e9', 'Manchester City', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', 2, 3),
  ('ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'Los Angeles Lakers', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('833e176f-2e0c-4eae-a2ce-6e0e36f3ebf9', 'Boston Celtics', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('a3c93b20-78d6-45e0-a2d9-d10a5729a5f4', 'Toronto Raptors', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('628c34f7-ae13-44a7-9072-10de8277dab4', 'Miami Heat', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('30b4c0a1-cc03-4d0c-8df4-57057d40d99e', 'New York Yankees', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('f181b90e-1a3c-4b05-8cc4-88e0a9adfbdc', 'Tampa Bay Rays', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('6ad0d08e-8a9c-4e34-93aa-97b81e30a1c5', 'Chicago White Sox', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('a82b4cfe-14b5-44dd-a7ad-263d588f7879', 'Miami Marlins', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'Ireland', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('6951e7b3-319a-4ce2-94c4-6d9a2e22e0a2', 'France', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('49089e68-462a-4eb6-8c49-6835bb8c1795', 'England', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('3a1b3de3-0ff4-4a1f-aad3-81dd1c7ed854', 'Wales', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('a021dc1e-7c8d-4717-aafc-9885290b15a6', 'Mumbai Indians', 'a021dc1e-7c8d-4717-aafc-9885290b15a6', 'a021dc1e-7c8d-4717-aafc-9885290b15a6', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('7d84bc72-e2ed-4c94-8b25-73b67e7642d3', 'Delhi Capitals', 'a021dc1e-7c8d-4717-aafc-9885290b15a6', 'a021dc1e-7c8d-4717-aafc-9885290b15a6', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('afd573de-5aa9-42c6-b7ca-e28ae2c4a58a', 'Punjab Kings', 'a021dc1e-7c8d-4717-aafc-9885290b15a6', 'a021dc1e-7c8d-4717-aafc-9885290b15a6', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('f1a7c6e8-55e0-45cc-91ff-eb546a95c194', 'Sunrisers Hyderabad', 'a021dc1e-7c8d-4717-aafc-9885290b15a6', 'a021dc1e-7c8d-4717-aafc-9885290b15a6', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('40a1a183-f098-4cfc-9f44-075c6ad7d72b', 'Tampa Bay Lightning', '40a1a183-f098-4cfc-9f44-075c6ad7d72b', '40a1a183-f098-4cfc-9f44-075c6ad7d72b', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('7c0cbe20-6d04-4d68-859e-87f250de410d', 'Huricanes', '40a1a183-f098-4cfc-9f44-075c6ad7d72b', '40a1a183-f098-4cfc-9f44-075c6ad7d72b', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('01a51ebf-2aa6-4a89-b6bf-46df786f3d99', 'Maple Leafs', '40a1a183-f098-4cfc-9f44-075c6ad7d72b', '40a1a183-f098-4cfc-9f44-075c6ad7d72b', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('3a88ea8b-c791-4dfb-bd17-5f542da4713c', 'Red Wings', '40a1a183-f098-4cfc-9f44-075c6ad7d72b', '40a1a183-f098-4cfc-9f44-075c6ad7d72b', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('b2074758-9e8d-4b1c-b43c-19093b635903', 'Dinamo Moscow', 'b2074758-9e8d-4b1c-b43c-19093b635903', 'b2074758-9e8d-4b1c-b43c-19093b635903', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('e17d96f9-9b17-4cf0-a54b-0c40b6789b4e', 'Tulitsa Tula', 'b2074758-9e8d-4b1c-b43c-19093b635903', 'b2074758-9e8d-4b1c-b43c-19093b635903', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('27cb4997-2b57-4fdd-9427-cb10a95e91f9', 'Lokomitiv', 'b2074758-9e8d-4b1c-b43c-19093b635903', 'b2074758-9e8d-4b1c-b43c-19093b635903', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('812b229f-06fa-4d7b-a768-e6a39bb291aa', 'Odintsovo', 'b2074758-9e8d-4b1c-b43c-19093b635903', 'b2074758-9e8d-4b1c-b43c-19093b635903', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('09b6c90e-ec84-4864-93b7-bdd7988bf777', 'Hrvatska', '09b6c90e-ec84-4864-93b7-bdd7988bf777', '09b6c90e-ec84-4864-93b7-bdd7988bf777', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('127e25a8-61db-4683-9574-b23ad9b9fb93', 'Canada', '09b6c90e-ec84-4864-93b7-bdd7988bf777', '09b6c90e-ec84-4864-93b7-bdd7988bf777', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('0e9c59f9-ec1c-4b0e-9b59-65297cb7c02f', 'Francuska', '09b6c90e-ec84-4864-93b7-bdd7988bf777', '09b6c90e-ec84-4864-93b7-bdd7988bf777', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('98b16844-2fb8-4e08-af22-f08d2ec71bd9', 'Italija', '09b6c90e-ec84-4864-93b7-bdd7988bf777', '09b6c90e-ec84-4864-93b7-bdd7988bf777', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'Paris Saint-Germain', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('759abf6c-13df-4b2a-82c3-2a9f291e6197', 'Nice', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('75da2857-dfa5-46ca-bf2a-9c407efc4a77', 'Monaco', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('7ae71768-c332-493b-b2bb-330de4a783bb', 'Lille', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('0d4f77e1-a089-4b72-8a54-ffe304b32f1d', 'Dinamo', null, '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('1c53994e-2bc1-42ac-b874-6f0b68b17644', 'Hajduk', null, '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('2dccc623-d70d-4d36-956a-dab882dd15c2', 'Rijeka', null, '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('3cf1854a-e8df-4e97-8d5d-dca5a7a96f4f', 'Istra', null, '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('4f75ae81-dabc-49e7-9d34-15503a889f45', 'Osijek', null, '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', null, 0),
  ('5ae0f123-c15f-424d-b769-872e047fb62b', 'Gorica', null, '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', null, 0);

-- Sample data for the Player table
INSERT INTO player (player_id, player_name, player_surname, player_age, player_height, player_weight, player_nationality, player_team, player_league, player_sport, player_admin) VALUES
  ('1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'Harry', 'Kane', 28, 185, 75, 'English', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a'),
  ('ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'LeBron', 'James', 36, 203, 113, 'American', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'auth0|653c25b9398960f19a6d8e6a'),
  ('30b4c0a1-cc03-4d0c-8df4-57057d40d99e', 'Babe', 'Ruth', 53, 191, 99, 'American', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e', 'auth0|653c25b9398960f19a6d8e6a'),
  ('ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'Johnny', 'Sexton', 36, 183, 88, 'Irish', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'auth0|653c25b9398960f19a6d8e6a'),
  ('a021dc1e-7c8d-4717-aafc-9885290b15a6', 'Rohit', 'Sharma', 34, 175, 72, 'Indian', 'a021dc1e-7c8d-4717-aafc-9885290b15a6', 'a021dc1e-7c8d-4717-aafc-9885290b15a6', 'a021dc1e-7c8d-4717-aafc-9885290b15a6', 'auth0|653c25b9398960f19a6d8e6a'),
  ('40a1a183-f098-4cfc-9f44-075c6ad7d72b', 'Nikita', 'Kucherov', 28, 180, 85, 'Russian', '40a1a183-f098-4cfc-9f44-075c6ad7d72b', '40a1a183-f098-4cfc-9f44-075c6ad7d72b', '40a1a183-f098-4cfc-9f44-075c6ad7d72b', 'auth0|653c25b9398960f19a6d8e6a'),
  ('b2074758-9e8d-4b1c-b43c-19093b635903', 'Sergey', 'Ignashevich', 42, 188, 85, 'Russian', 'b2074758-9e8d-4b1c-b43c-19093b635903', 'b2074758-9e8d-4b1c-b43c-19093b635903', 'b2074758-9e8d-4b1c-b43c-19093b635903', 'auth0|653c25b9398960f19a6d8e6a'),
  ('09b6c90e-ec84-4864-93b7-bdd7988bf777', 'Marin', 'Cilic', 35, 172, 66, 'Croatian', '09b6c90e-ec84-4864-93b7-bdd7988bf777', '09b6c90e-ec84-4864-93b7-bdd7988bf777', '09b6c90e-ec84-4864-93b7-bdd7988bf777', 'auth0|653c25b9398960f19a6d8e6a'),
  ('c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'Neymar', 'Jr', 29, 175, 68, 'Brazilian', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'auth0|653c25b9398960f19a6d8e6a');
-- Sample data for the Schedule table
INSERT INTO schedule (schedule_id, schedule_league, schedule_admin) VALUES
  ('6f882d93-62d1-4b04-afc9-674c30fb3668', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a');

UPDATE league SET league_schedule = '6f882d93-62d1-4b04-afc9-674c30fb3668' WHERE league_id = '1b76a8c6-4f0d-4be2-b431-00509fb9be9d';
-- -- Sample data for the Match table
INSERT INTO match (match_id, match_home_team, match_away_team, match_home_team_score, match_away_team_score, match_date, match_league, match_admin, schedule_id) VALUES
  ('c634f762-3c59-4f19-b63f-b73359a7c316', 'Manchester City', 'Manchester United', NULL, NULL, '2023-11-13 21:00:00', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', '6f882d93-62d1-4b04-afc9-674c30fb3668'),
  ('b6f15649-5c0a-442d-9b67-dd1b2defe507', 'Arsenal', 'Liverpool', NULL, NULL, '2023-11-13 21:00:00', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', '6f882d93-62d1-4b04-afc9-674c30fb3668'),
  ('e6b07871-6c75-4998-a3e6-47e9f63c5b9e', 'Arsenal', 'Manchester United', NULL, NULL, '2023-11-18 21:00:00', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', '6f882d93-62d1-4b04-afc9-674c30fb3668'),
  ('e5eb4dd7-f698-4779-a9cd-872fc136d311', 'Liverpool', 'Manchester City', NULL, NULL, '2023-11-18 21:00:00', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', '6f882d93-62d1-4b04-afc9-674c30fb3668'),
  ('339bd914-f77c-4b34-8e30-4c76efc28214', 'Liverpool', 'Manchester United', 4, 3, '2023-11-08 21:00:00', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', '6f882d93-62d1-4b04-afc9-674c30fb3668'),
  ('8dd67f3e-02b5-4ec8-a11a-f6d7dc76306d', 'Manchester City', 'Arsenal', 2, 1, '2023-11-08 21:00:00', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'auth0|653c25b9398960f19a6d8e6a', '6f882d93-62d1-4b04-afc9-674c30fb3668');

-- Connect leagues and teams
INSERT INTO league_teams (leaguedao_league_id, teams_team_id) VALUES
  ('1b76a8c6-4f0d-4be2-b431-00509fb9be9d', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d'),
  ('1b76a8c6-4f0d-4be2-b431-00509fb9be9d', 'e4b4df8d-97aa-47f9-9313-d5d8c58c5aa4'),
  ('1b76a8c6-4f0d-4be2-b431-00509fb9be9d', '41b13c22-ef43-4d8a-aab2-fa05e897c285'),
  ('1b76a8c6-4f0d-4be2-b431-00509fb9be9d', '2e4a9c63-7a57-4ebc-a0e0-1a67651a70e9'),

  ('ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be'),
  ('ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', '833e176f-2e0c-4eae-a2ce-6e0e36f3ebf9'),
  ('ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'a3c93b20-78d6-45e0-a2d9-d10a5729a5f4'),
  ('ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', '628c34f7-ae13-44a7-9072-10de8277dab4'),

  ('30b4c0a1-cc03-4d0c-8df4-57057d40d99e', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e'),
  ('30b4c0a1-cc03-4d0c-8df4-57057d40d99e', 'f181b90e-1a3c-4b05-8cc4-88e0a9adfbdc'),
  ('30b4c0a1-cc03-4d0c-8df4-57057d40d99e', '6ad0d08e-8a9c-4e34-93aa-97b81e30a1c5'),
  ('30b4c0a1-cc03-4d0c-8df4-57057d40d99e', 'a82b4cfe-14b5-44dd-a7ad-263d588f7879'),

  ('ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645'),
  ('ad3b4e22-1f0a-4b18-a4cd-62f712f08645', '6951e7b3-319a-4ce2-94c4-6d9a2e22e0a2'),
  ('ad3b4e22-1f0a-4b18-a4cd-62f712f08645', '49089e68-462a-4eb6-8c49-6835bb8c1795'),
  ('ad3b4e22-1f0a-4b18-a4cd-62f712f08645', '3a1b3de3-0ff4-4a1f-aad3-81dd1c7ed854'),

  ('a021dc1e-7c8d-4717-aafc-9885290b15a6', 'a021dc1e-7c8d-4717-aafc-9885290b15a6'),
  ('a021dc1e-7c8d-4717-aafc-9885290b15a6', '7d84bc72-e2ed-4c94-8b25-73b67e7642d3'),
  ('a021dc1e-7c8d-4717-aafc-9885290b15a6', 'afd573de-5aa9-42c6-b7ca-e28ae2c4a58a'),
  ('a021dc1e-7c8d-4717-aafc-9885290b15a6', 'f1a7c6e8-55e0-45cc-91ff-eb546a95c194'),

  ('40a1a183-f098-4cfc-9f44-075c6ad7d72b', '40a1a183-f098-4cfc-9f44-075c6ad7d72b'),
  ('40a1a183-f098-4cfc-9f44-075c6ad7d72b', '7c0cbe20-6d04-4d68-859e-87f250de410d'),
  ('40a1a183-f098-4cfc-9f44-075c6ad7d72b', '01a51ebf-2aa6-4a89-b6bf-46df786f3d99'),
  ('40a1a183-f098-4cfc-9f44-075c6ad7d72b', '3a88ea8b-c791-4dfb-bd17-5f542da4713c'),

  ('b2074758-9e8d-4b1c-b43c-19093b635903', 'b2074758-9e8d-4b1c-b43c-19093b635903'),
  ('b2074758-9e8d-4b1c-b43c-19093b635903', 'e17d96f9-9b17-4cf0-a54b-0c40b6789b4e'),
  ('b2074758-9e8d-4b1c-b43c-19093b635903', '27cb4997-2b57-4fdd-9427-cb10a95e91f9'),
  ('b2074758-9e8d-4b1c-b43c-19093b635903', '812b229f-06fa-4d7b-a768-e6a39bb291aa'),

  ('09b6c90e-ec84-4864-93b7-bdd7988bf777', '09b6c90e-ec84-4864-93b7-bdd7988bf777'),
  ('09b6c90e-ec84-4864-93b7-bdd7988bf777', '127e25a8-61db-4683-9574-b23ad9b9fb93'),
  ('09b6c90e-ec84-4864-93b7-bdd7988bf777', '0e9c59f9-ec1c-4b0e-9b59-65297cb7c02f'),
  ('09b6c90e-ec84-4864-93b7-bdd7988bf777', '98b16844-2fb8-4e08-af22-f08d2ec71bd9'),

  ('c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569'),
  ('c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', '759abf6c-13df-4b2a-82c3-2a9f291e6197'),
  ('c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', '75da2857-dfa5-46ca-bf2a-9c407efc4a77'),
  ('c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', '7ae71768-c332-493b-b2bb-330de4a783bb');
-- Connect sports and leagues
INSERT INTO sport_leagues (sportdao_sport_id, leagues_league_id) VALUES
  ('1b76a8c6-4f0d-4be2-b431-00509fb9be9d', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d'),
  ('ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be'),
  ('30b4c0a1-cc03-4d0c-8df4-57057d40d99e', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e'),
  ('ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645'),
  ('a021dc1e-7c8d-4717-aafc-9885290b15a6', 'a021dc1e-7c8d-4717-aafc-9885290b15a6'),
  ('40a1a183-f098-4cfc-9f44-075c6ad7d72b', '40a1a183-f098-4cfc-9f44-075c6ad7d72b'),
  ('b2074758-9e8d-4b1c-b43c-19093b635903', 'b2074758-9e8d-4b1c-b43c-19093b635903'),
  ('09b6c90e-ec84-4864-93b7-bdd7988bf777', '09b6c90e-ec84-4864-93b7-bdd7988bf777'),
  ('c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569');

-- Connect teams and players
INSERT INTO team_players (teamdao_team_id, players_player_id) VALUES
  ('1b76a8c6-4f0d-4be2-b431-00509fb9be9d', '1b76a8c6-4f0d-4be2-b431-00509fb9be9d'),
  ('ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be', 'ef5a4ad9-45e7-4ed6-bc8a-89c58392a6be'),
  ('30b4c0a1-cc03-4d0c-8df4-57057d40d99e', '30b4c0a1-cc03-4d0c-8df4-57057d40d99e'),
  ('ad3b4e22-1f0a-4b18-a4cd-62f712f08645', 'ad3b4e22-1f0a-4b18-a4cd-62f712f08645'),
  ('a021dc1e-7c8d-4717-aafc-9885290b15a6', 'a021dc1e-7c8d-4717-aafc-9885290b15a6'),
  ('40a1a183-f098-4cfc-9f44-075c6ad7d72b', '40a1a183-f098-4cfc-9f44-075c6ad7d72b'),
  ('b2074758-9e8d-4b1c-b43c-19093b635903', 'b2074758-9e8d-4b1c-b43c-19093b635903'),
  ('09b6c90e-ec84-4864-93b7-bdd7988bf777', '09b6c90e-ec84-4864-93b7-bdd7988bf777'),
  ('c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569', 'c8a4b5ec-cde9-4a43-9ed1-9718c6d9e569');
